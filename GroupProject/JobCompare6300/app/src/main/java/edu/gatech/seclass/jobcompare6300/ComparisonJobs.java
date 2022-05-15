package edu.gatech.seclass.jobcompare6300;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparisonJobs extends AppCompatActivity {
//    private ArrayList<Double> scoreList;
//    private ArrayList<Job> jobList;
//    private HashMap<Double, Job> scoreJobMap = new HashMap<>();
//    private ArrayList<String> rankedJobList = new ArrayList<>();

    private RecyclerView rankRecyclerView;
    private RankRecyclerAdapter rankRecyclerAdapter;
    private ArrayList<JobItem> jobItemList;

    private LinearLayout layoutTable;

    private Button compareButton;

//    public ArrayList<Job> readJobs() {
//        // on below line we are creating a
//        // database for reading our database.
//        DB db = new DB(this);
//        // on below line we are creating a cursor with query to read data from database.
//        Cursor cursorJobs = db.getAllData(DB.JOB_LIST_TABLE);
//
//        // on below line we are creating a new array list.
//        ArrayList<Job> jobArrayList = new ArrayList<>();
//
//        if (cursorJobs.moveToFirst()) {
//            do {
//                // on below line we are adding the data from cursor to our array list.
//                jobArrayList.add(new Job(cursorJobs.getString(1),
//                        cursorJobs.getString(2),
//                        cursorJobs.getString(3),
//                        Double.parseDouble(cursorJobs.getString(4)),
//                        Double.parseDouble(cursorJobs.getString(5)),
//                        Double.parseDouble(cursorJobs.getString(6)),
//                        Double.parseDouble(cursorJobs.getString(7)),
//                        Double.parseDouble(cursorJobs.getString(8)),
//                        Double.parseDouble(cursorJobs.getString(9))));
//            } while (cursorJobs.moveToNext());
//            // moving our cursor to next.
//        }
//
//
//        // at last closing our cursor
//        // and returning our array list.
//        cursorJobs.close();
//        return jobArrayList;
//    }
//
//
//
//    public Double calculateScore(Job job){
//        Double salary = job.getSalary();
//        Double cost = job.getCost();
//        Double bonus = job.getBonus();
//        Double benefits = job.getBenefits();
//        Double stipend = job.getStipend();
//        Double award = job.getAward();
//        return (salary - cost) + (bonus - cost) + stipend
//                + (benefits * (salary - cost) / 100.0) + (award / 4.0);
//    }

//    public void makeScoreList() {
//        for (Job job: jobList){
//            scoreList.add(calculateScore(job));
//        }
//    }
//
//    public void makeHash() {
//        for (int i = 0; i < jobList.size(); i++) {
//            scoreJobMap.put(scoreList.get(i), jobList.get(i));
//        }
//    }
//
//    public void rankedJobs() {
//        Collections.sort(scoreList, Collections.reverseOrder());
//        for (int i = 0; i < scoreList.size(); i++) {
//            rankedJobList.add(scoreJobMap.get(scoreList.get(i)).getTitleJob() + " "
//            + scoreJobMap.get(scoreList.get(i)).getCompany());
//        }
//    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rank_jobs);

        // Create a list of study fields.

//        ArrayList<String> stuff = rankedJobList;

        // Find a reference to the
        //{@link ListView} in the layout

//        ListView itemListView = (ListView)findViewById(R.id.list);
//
//        // Create a new {@link ArrayAdapter}
//        // of study fields
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stuff);
//
//        // Set the adapter
//        // on the {@link ListView}
//        // so the list can be populated
//        /// in the user interface
//
//        itemListView.setAdapter(adapter);
//
//        jobList = readJobs();

        rankRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        compareButton = (Button) findViewById(R.id.compare);
        layoutTable = (LinearLayout) findViewById(R.id.layoutTable);


        //init adapter
        rankRecyclerAdapter = new RankRecyclerAdapter();

        //init view
        rankRecyclerView.setAdapter(rankRecyclerAdapter);
        rankRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        jobItemList = new ArrayList<>();

        DB db = new DB(this);
        //put data
        Cursor mine = db.getAllData(DB.MY_JOB_TABLE);
        if (mine.getCount() == 0) {
            Log.w("tag", "nothing");
        } else {
            while ((mine.moveToNext())) {
                Log.w("id", mine.getString(0));

                JobItem job = new JobItem(mine.getString(1),
                        mine.getString(2),
                        mine.getString(3),
                        mine.getString(4),
                        mine.getString(5),
                        mine.getString(6),
                        mine.getString(7),
                        mine.getString(8),
                        mine.getString(9),
                        mine.getString(10));

                jobItemList.add(job);
            }
        }

        Cursor jobList = db.getAllData(DB.JOB_LIST_TABLE);
        if (jobList.getCount() == 0) {
            Log.w("tag", "nothing");
        } else {
            while ((jobList.moveToNext())) {
                //Log.w("id",mine.getString(0));

                JobItem job = new JobItem(jobList.getString(1),
                        jobList.getString(2),
                        jobList.getString(3),
                        jobList.getString(4),
                        jobList.getString(5),
                        jobList.getString(6),
                        jobList.getString(7),
                        jobList.getString(8),
                        jobList.getString(9),
                        jobList.getString(10));

                jobItemList.add(job);

            }
        }



        jobItemList.sort(new Comparator<JobItem>() {
            @Override
            public int compare(JobItem job0, JobItem job1) {
                Double score0 = Double.parseDouble(job0.getScore());
                Double score1 = Double.parseDouble(job1.getScore());
                if (score0 == score1)
                    return 0;
                else if (score1 > score0)
                    return 1;
                else
                    return -1;
            }
        });

        rankRecyclerAdapter.setRankList(jobItemList);
        layoutTable.setVisibility(View.GONE);
    }

    public void compareButtonClicked(View view) {

        ArrayList<JobItem> selectedList = new ArrayList<>();;

        for (int i = 0; i < jobItemList.size(); i++) {
            JobItem job = jobItemList.get(i);
            if (job.isSelected() == true) {
                selectedList.add(job);
            }
        }

//        Log.w("count", count.toString());

        if (selectedList.size() != 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ComparisonJobs.this);
            builder.setTitle("Error Message");
            builder.setMessage("Please Select Two Job Infromation");
            builder.setNegativeButton("OK", null);
            builder.create().show();
            layoutTable.setVisibility(View.GONE);
            return;
        }

        layoutTable.setVisibility(View.VISIBLE);

        TextView title_f = (TextView) findViewById(R.id.firstT);
        TextView company_f = (TextView) findViewById(R.id.firstC);
        TextView location_f = (TextView) findViewById(R.id.firstL);
        TextView salary_f = (TextView) findViewById(R.id.firstYS);
        TextView bonus_f = (TextView) findViewById(R.id.firstYB);
        TextView benefits_f = (TextView) findViewById(R.id.firstRB);
        TextView stipend_f = (TextView) findViewById(R.id.firstRS);
        TextView award_f = (TextView) findViewById(R.id.firstRSU);

        JobItem firstJob = selectedList.get(0);
        title_f.setText(firstJob.getTitle());
        company_f.setText(firstJob.getCompany());
        location_f.setText(firstJob.getLocation());
        salary_f.setText(firstJob.getSalary());
        bonus_f.setText(firstJob.getBonus());
        benefits_f.setText(firstJob.getBenefits());
        stipend_f.setText(firstJob.getStipend());
        award_f.setText(firstJob.getAward());


        TextView title_s = (TextView) findViewById(R.id.secondT);
        TextView company_s = (TextView) findViewById(R.id.secondC);
        TextView location_s = (TextView) findViewById(R.id.secondL);
        TextView salary_s = (TextView) findViewById(R.id.secondYS);
        TextView bonus_s = (TextView) findViewById(R.id.secondYB);
        TextView benefits_s = (TextView) findViewById(R.id.secondRB);
        TextView stipend_s = (TextView) findViewById(R.id.secondRS);
        TextView award_s = (TextView) findViewById(R.id.secondRSU);

        JobItem secondJob = selectedList.get(1);
        title_s.setText(secondJob.getTitle());
        company_s.setText(secondJob.getCompany());
        location_s.setText(secondJob.getLocation());
        salary_s.setText(secondJob.getSalary());
        bonus_s.setText(secondJob.getBonus());
        benefits_s.setText(secondJob.getBenefits());
        stipend_s.setText(secondJob.getStipend());
        award_s.setText(secondJob.getAward());





    }
}










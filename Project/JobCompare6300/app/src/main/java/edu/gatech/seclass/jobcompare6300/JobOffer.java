package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class JobOffer extends AppCompatActivity {

    DB dataBase;

    private EditText title;
    private EditText company;
    private EditText location;
    private EditText cost;
    private EditText salary;
    private EditText bonus;
    private EditText benefits;
    private EditText stipend;
    private EditText award;

    private Button resetButton;
    private Button saveButton;
    private Button jobComparisonButton;
    private CurrentJob currentJob;
    private LinearLayout layoutTable;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_offer);

        title = (EditText) findViewById(R.id.titleEdit);
        company = (EditText) findViewById(R.id.companyEdit);
        location = (EditText) findViewById(R.id.locationEdit);
        cost = (EditText) findViewById(R.id.costEdit);
        salary = (EditText) findViewById(R.id.salaryEdit);
        bonus = (EditText) findViewById(R.id.bonusEdit);
        benefits = (EditText) findViewById(R.id.benefitsEdit);
        stipend = (EditText) findViewById(R.id.stipendEdit);
        award = (EditText) findViewById(R.id.awardEdit);


        resetButton = (Button) findViewById(R.id.reset);
        saveButton = (Button) findViewById(R.id.save);
        jobComparisonButton = (Button) findViewById(R.id.jobComparison);

        dataBase = new DB(this);
        layoutTable = (LinearLayout) findViewById(R.id.layoutTable);

//        JobItem job = new JobItem("web developer",
//                "amazon",
//                "ny",
//                "2000",
//                "1600000",
//                "30000",
//                "10000",
//                "70",
//                "15000",
//                "");
//
//        Double score = calculateScore(job);
//
//        boolean isInsert = dataBase.insertJobData("web developer",
//                "amazon",
//                "ny",
//                "2000",
//                "1600000",
//                "30000",
//                "10000",
//                "70",
//                "15000",
//                score.toString(),
//                DB.JOB_LIST_TABLE);
        layoutTable.setVisibility(View.GONE);
    }

    private Double calculateScore(JobItem job){
        Double salary = Double.parseDouble(job.getSalary());
        Double cost = Double.parseDouble(job.getCost());
        Double bonus = Double.parseDouble(job.getBonus());
        Double benefits = Double.parseDouble(job.getBenefits());
        Double stipend = Double.parseDouble(job.getStipend());
        Double award = Double.parseDouble(job.getAward());

        Cursor weight = dataBase.getAllData(DB.WEIGHT_TABLE);

        if (weight.getCount() == 0) {
            Log.w("tag", "nothing");
            return 1/7 * ((salary - cost) + (bonus - cost) + stipend
                    + (benefits * (salary - cost) / 100.0) + (award / 4.0));
        } else {
            while ((weight.moveToNext())) {
                Log.w("id",weight.getString(0));
                Integer s = Integer.parseInt(weight.getString(1));
                Integer b = Integer.parseInt(weight.getString(2));
                Integer be = Integer.parseInt(weight.getString(3));
                Integer st = Integer.parseInt(weight.getString(4));
                Integer a = Integer.parseInt(weight.getString(5));

                return s/7 * (salary - cost) + b/7 * (bonus - cost) + be/7 * stipend
                        + st/7 * (benefits * (salary - cost) / 100.0) + a/7 * (award / 4.0);
            }
        }
        return 0.0;
    }

    public void saveButtonClicked(View view) {
        String title_string = title.getText().toString();
        String company_string = company.getText().toString();
        String location_string = location.getText().toString();
        String cost_string = cost.getText().toString();
        String salary_string = salary.getText().toString();
        String bonus_string = bonus.getText().toString();
        String benefits_string = benefits.getText().toString();
        String stipend_string = stipend.getText().toString();
        String award_string = award.getText().toString();

        Log.e("dd",title_string);

        if (title_string.length() == 0 || company_string.length() == 0 || location_string.length() == 0 || cost_string.length() == 0
                || salary_string.length() == 0 || bonus_string.length() == 0 || benefits_string.length() == 0 || benefits_string.length() == 0
                || stipend_string.length() == 0 || award_string.length() == 0) {
            Log.e("a", "wrong");
            AlertDialog.Builder builder = new AlertDialog.Builder(JobOffer.this);
            builder.setTitle("Error Message");
            builder.setMessage("Please Enter All Offer Job Infromation");
            builder.setNegativeButton("YES", null);
            builder.create().show();
            return;
        }

        JobItem job = new JobItem(title_string,
                company_string,
                location_string,
                cost_string,
                salary_string,
                bonus_string,
                benefits_string,
                stipend_string,
                award_string,
                "");

        Double score = calculateScore(job);


        boolean isInsert = dataBase.insertJobData(title_string,
                company_string,
                location_string,
                cost_string,
                salary_string,
                bonus_string,
                benefits_string,
                stipend_string,
                award_string,
                score.toString(),
                DB.JOB_LIST_TABLE);

        if (isInsert) {
            Log.e("a", "success");
            AlertDialog.Builder builder = new AlertDialog.Builder(JobOffer.this);
            builder.setTitle("Alert Message");
            builder.setMessage("Success to Save");
            builder.setNegativeButton("Done", null);
            builder.create().show();
        } else {
            Log.e("a", "fail");
            AlertDialog.Builder builder = new AlertDialog.Builder(JobOffer.this);
            builder.setTitle("Error Message");
            builder.setMessage("Fail to save");
            builder.setNegativeButton("Done", null);
            builder.create().show();
        }
    }

    public void resetButtonClicked(View view) {
        title.setText("");
        company.setText("");
        location.setText("");
        cost.setText("");
        salary.setText("");
        bonus.setText("");
        benefits.setText("");
        stipend.setText("");
        award.setText("");

    }

 //   public void jobComparisionButtonClicked(View view) {
 //       Intent intent = new Intent(getApplicationContext(), ComparisonJobs.class);
  //      startActivity(intent);
  //  }

    public void jobComparisionButtonClicked(View view) {
        String title_string = title.getText().toString();
        String company_string = company.getText().toString();
        String location_string = location.getText().toString();
        String cost_string = cost.getText().toString();
        String salary_string = salary.getText().toString();
        String bonus_string = bonus.getText().toString();
        String benefits_string = benefits.getText().toString();
        String stipend_string = stipend.getText().toString();
        String award_string = award.getText().toString();
        ArrayList<JobItem> selectedList = new ArrayList<>();

        DB db = new DB(this);
        //put data
        Cursor mine = db.getAllData(DB.MY_JOB_TABLE);
        if (mine.getCount() == 0) {
            Log.w("tag", "nothing");
            AlertDialog.Builder builder = new AlertDialog.Builder(JobOffer.this);
            builder.setTitle("Alert Message");
            builder.setMessage("Current Job Information is not saved");
            builder.setNegativeButton("Done", null);
            builder.create().show();
            layoutTable.setVisibility(View.GONE);
            return;
        }
        else {
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

                selectedList.add(job);
            }
        }

        if (title_string.length() == 0 || company_string.length() == 0 || location_string.length() == 0 || cost_string.length() == 0
                || salary_string.length() == 0 || bonus_string.length() == 0 || benefits_string.length() == 0 || benefits_string.length() == 0
                || stipend_string.length() == 0 || award_string.length() == 0) {
            Log.e("a", "wrong");
            AlertDialog.Builder builder = new AlertDialog.Builder(JobOffer.this);
            builder.setTitle("Error Message");
            builder.setMessage("Please Enter All Offer Job Infromation");
            builder.setNegativeButton("YES", null);
            builder.create().show();
            layoutTable.setVisibility(View.GONE);
            return;
        }

        selectedList.add(new JobItem(title_string,
                company_string,
                location_string,
                cost_string,
                salary_string,
                bonus_string,
                benefits_string,
                stipend_string,
                award_string,
                ""));

//        Log.w("count", count.toString());

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

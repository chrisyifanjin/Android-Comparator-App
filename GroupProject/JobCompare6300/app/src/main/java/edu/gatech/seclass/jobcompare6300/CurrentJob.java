package edu.gatech.seclass.jobcompare6300;

import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CurrentJob extends AppCompatActivity {

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_job);

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

        dataBase = new DB(this);

        Cursor list = dataBase.getAllData(DB.MY_JOB_TABLE);
        if (list.getCount() == 0) {
            Log.w("tag", "nothing");
        } else {
            while ((list.moveToNext())) {
                Log.w("id",list.getString(0));
                title.setText(list.getString(1));
                company.setText(list.getString(2));
                location.setText(list.getString(3));
                cost.setText(list.getString(4));
                salary.setText(list.getString(5));
                bonus.setText(list.getString(6));
                benefits.setText(list.getString(7));
                stipend.setText(list.getString(8));
                award.setText(list.getString(9));
            }
        }
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

        if (title_string.length() == 0 || company_string.length() == 0 || location_string.length() == 0 || cost_string.length() == 0
        || salary_string.length() == 0 || bonus_string.length() == 0 || benefits_string.length() == 0 || benefits_string.length() == 0
        || stipend_string.length() == 0 || award_string.length() == 0) {
            Log.e("a", "wrong");
            AlertDialog.Builder builder = new AlertDialog.Builder(CurrentJob.this);
            builder.setTitle("Error Message");
            builder.setMessage("Please Enter All Job Infromation");
            builder.setNegativeButton("YES", null);
            builder.create().show();
            return;
        }

        Cursor list = dataBase.getAllData(DB.MY_JOB_TABLE);
        if (list.getCount() == 0) {

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
                    DB.MY_JOB_TABLE);

            if (isInsert == true) {
                Log.e("a", "success");
                AlertDialog.Builder builder = new AlertDialog.Builder(CurrentJob.this);
                builder.setTitle("Alert Message");
                builder.setMessage("Success to Save");
                builder.setNegativeButton("Done", null);
                builder.create().show();
            } else {
                Log.e("a", "fail");
                AlertDialog.Builder builder = new AlertDialog.Builder(CurrentJob.this);
                builder.setTitle("Error Message");
                builder.setMessage("Fail to save");
                builder.setNegativeButton("Done", null);
                builder.create().show();
            }
        } else {

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

            dataBase.updateJobData("1",
                    title_string,
                    company_string,
                    location_string,
                    cost_string,
                    salary_string,
                    bonus_string,
                    benefits_string,
                    stipend_string,
                    award_string,
                    score.toString(),
                    DB.MY_JOB_TABLE);

            AlertDialog.Builder builder = new AlertDialog.Builder(CurrentJob.this);
            builder.setTitle("Alert Message");
            builder.setMessage("Success to Update");
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



}

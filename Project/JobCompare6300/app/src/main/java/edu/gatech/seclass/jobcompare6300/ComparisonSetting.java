package edu.gatech.seclass.jobcompare6300;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ComparisonSetting extends AppCompatActivity  {

    DB dataBase;

    private EditText salary;
    private EditText bonus;
    private EditText benefits;
    private EditText stipend;
    private EditText award;

    private Button resetButton;
    private Button saveButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparison_setting);

        salary = (EditText) findViewById(R.id.salaryWeight);
        bonus = (EditText) findViewById(R.id.bonusWeight);
        benefits = (EditText) findViewById(R.id.benefitsWeight);
        stipend = (EditText) findViewById(R.id.stipendWeight);
        award = (EditText) findViewById(R.id.awardWeight);

        resetButton = (Button) findViewById(R.id.reset);
        saveButton = (Button) findViewById(R.id.save);

        dataBase = new DB(this);

        Cursor list = dataBase.getAllData(DB.WEIGHT_TABLE);
        if (list.getCount() == 0) {
            Log.w("tag", "comparison setting is empty");
            boolean isInsert = dataBase.insertWeightData("1", "1", "1", "1", "1");
            if (isInsert) {
                Log.w("tag", "comparison setting is initialized with all the values to be 1");
                salary.setText("1");
                bonus.setText("1");
                benefits.setText("1");
                stipend.setText("1");
                award.setText("1");
            }
        } else {
            while ((list.moveToNext())) {
                Log.w("id",list.getString(0));
                salary.setText(list.getString(1));
                bonus.setText(list.getString(2));
                benefits.setText(list.getString(3));
                stipend.setText(list.getString(4));
                award.setText(list.getString(5));
            }
        }
    }


    public void saveButtonClicked(View view) {
        String salary_string = salary.getText().toString();
        String bonus_string = bonus.getText().toString();
        String benefits_string = benefits.getText().toString();
        String stipend_string = stipend.getText().toString();
        String award_string = award.getText().toString();

        if (salary_string == "" || bonus_string == "" || benefits_string == "" || benefits_string == ""
                || stipend_string == "" || award_string == "") {
            Log.e("a", "wrong");
            return;
        }

        Cursor list = dataBase.getFirstData(DB.WEIGHT_TABLE);

        dataBase.updateWeightData("1",
                salary_string,
                bonus_string,
                benefits_string,
                stipend_string,
                award_string);
        Log.w("tag", "comparison setting is updated");

        AlertDialog.Builder builder = new AlertDialog.Builder(ComparisonSetting.this);
        builder.setTitle("Alert Message");
        builder.setMessage("Success to Save");
        builder.setNegativeButton("Done", null);
        builder.create().show();
    }

    public void resetButtonClicked(View view) {
        salary.setText("1");
        bonus.setText("1");
        benefits.setText("1");
        stipend.setText("1");
        award.setText("1");
    }

}

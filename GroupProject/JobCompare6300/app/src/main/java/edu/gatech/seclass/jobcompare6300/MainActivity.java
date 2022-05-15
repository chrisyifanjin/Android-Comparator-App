package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    private Button currentJob;
    private Button jobOffer;
    private Button comparisonSetting;
    private Button jobComparision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentJob = (Button) findViewById(R.id.currentJob);
        jobOffer = (Button) findViewById(R.id.jobOffer);
        comparisonSetting = (Button) findViewById(R.id.comparisonSetting);
        jobComparision = (Button) findViewById(R.id.jobComparison);
    }

    public void currentJobButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), CurrentJob.class);
        startActivity(intent);
    }

    public void jobOfferButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), JobOffer.class);
        startActivity(intent);
    }

    public void comparisonSettingButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), ComparisonSetting.class);
        startActivity(intent);
    }

    public void jobComparisionButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), ComparisonJobs.class);
        startActivity(intent);
    }

}

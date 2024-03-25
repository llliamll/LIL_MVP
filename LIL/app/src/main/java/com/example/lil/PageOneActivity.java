package com.example.lil; // Change this to your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PageOneActivity extends AppCompatActivity {

    private String reportName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view to your layout for this activity
        setContentView(R.layout.report_1_p1);

        // Enable the Up button in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final EditText editText = (EditText) findViewById(R.id.nameField);
        Button buttonNext = findViewById(R.id.Next);
        buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reportName = editText.getText().toString();
                Intent intent = new Intent(PageOneActivity.this, ReportOneStepTwo.class);
                startActivity(intent);
            }
        });
    }

    public String getName() {
        return this.reportName;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // This is the Up button's ID. When it's clicked, we finish() this
        // activity and return to the parent activity specified in the manifest.
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
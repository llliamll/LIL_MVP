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
        setContentView(R.layout.report_1_p1);

        //save the entered name and go to next page
        final EditText editText = (EditText) findViewById(R.id.nameField);
        Button buttonNext = findViewById(R.id.Next);
        buttonNext.setOnClickListener( v-> {
            Intent intent = new Intent(PageOneActivity.this, ReportOneStepTwo.class);
            startActivity(intent);
//            @Override
//            public void onClick(View v) {
//                //reportName = editText.getText().toString();
//                Intent intent = new Intent(PageOneActivity.this, ReportOneStepTwo.class);
//                startActivity(intent);
//            }
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {
            Intent intent = new Intent(PageOneActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    public String getName() {
        return this.reportName;
    }
}
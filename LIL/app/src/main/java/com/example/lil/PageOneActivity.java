package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
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
        buttonNext.setOnClickListener( v-> {//record name and go to step two
            reportName = editText.getText().toString();
            Intent intent = new Intent(PageOneActivity.this, ReportOneStepTwo.class);
            startActivity(intent);
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {//back to menu
            Intent intent = new Intent(PageOneActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//back to last step
            Intent intent = new Intent(PageOneActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    public String getName() { return this.reportName; }
}
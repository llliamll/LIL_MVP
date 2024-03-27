package com.example.lil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.Button;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class PageOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //display name
        TextView username = findViewById(R.id.menuUsername);
        String text = "Welcome <b>" + getIntent().getStringExtra("username") + "</b>";
        username.setText(Html.fromHtml(text,Html.FROM_HTML_MODE_LEGACY));

        //go to report 1
        Button buttonReportOne = findViewById(R.id.buttonPageOne);
        buttonReportOne.setOnClickListener(v -> {
            Intent intent = new Intent(PageOneActivity.this, ReportOneStepTwo.class);
            startActivity(intent);
        });

        //display a message for other buttons
        Button buttonReportTwo = findViewById(R.id.buttonPageTwo);
        otherButtons(buttonReportTwo);
        Button buttonReportThree = findViewById(R.id.buttonPageThree);
        otherButtons(buttonReportThree);
        Button buttonReportFour = findViewById(R.id.buttonPageFour);
        otherButtons(buttonReportFour);
        Button buttonReportFive = findViewById(R.id.buttonPageFive);
        otherButtons(buttonReportFive);
        Button buttonReportSix = findViewById(R.id.buttonPageSix);
        otherButtons(buttonReportSix);
    }

    private void otherButtons(Button button){
        button.setOnClickListener(v -> {
            Toast.makeText(PageOneActivity.this, "Not Yet Implemented...", Toast.LENGTH_SHORT).show();
        });
    }
}
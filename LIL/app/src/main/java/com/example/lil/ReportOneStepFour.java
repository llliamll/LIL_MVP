package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ReportOneStepFour extends AppCompatActivity implements retrieveLocation{
    private String size, activity, location;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_1_p4);

        //get previous variable(s)
        Intent getVariable = getIntent();
        size = getVariable.getStringExtra("size");
        activity = getVariable.getStringExtra("activity");



        final EditText editText = (EditText) findViewById(R.id.locationField);
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {//record size and go to step three
            location = editText.getText().toString();
            Intent intent = new Intent(ReportOneStepFour.this, ReportOneStepFive.class);
            //again this is a temp solution
            intent.putExtra("size", size);
            intent.putExtra("activity", activity);
            intent.putExtra("location", location);
            startActivity(intent);
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {//go back to main menu
            Intent intent = new Intent(ReportOneStepFour.this, PageOneActivity.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//go to step one
            Intent intent = new Intent(ReportOneStepFour.this, ReportOneStepThree.class);
            startActivity(intent);
        });
    }
    @Override
    public String getLocation() { return location; }

}

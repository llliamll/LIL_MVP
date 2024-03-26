package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ReportOneStepFive extends AppCompatActivity implements retrieveUnit{
    private String size, activity, location, unit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_1_p5);

        //get previous variable(s)
        Intent getVariable = getIntent();
        size = getVariable.getStringExtra("size");
        activity = getVariable.getStringExtra("activity");
        location = getVariable.getStringExtra("location");


        final EditText editText = (EditText) findViewById(R.id.unitField);
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {//record size and go to step three
            unit = editText.getText().toString();
            Intent intent = new Intent(ReportOneStepFive.this, ReportOneStepSix.class);
            //again this is a temp solution
            intent.putExtra("size", size);
            intent.putExtra("activity", activity);
            intent.putExtra("location", location);
            intent.putExtra("unit", unit);
            startActivity(intent);
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {//go back to main menu
            Intent intent = new Intent(ReportOneStepFive.this, MainActivity.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//go to step one
            Intent intent = new Intent(ReportOneStepFive.this, ReportOneStepFour.class);
            startActivity(intent);
        });
    }
    @Override
    public String getUnit() { return unit; }

}

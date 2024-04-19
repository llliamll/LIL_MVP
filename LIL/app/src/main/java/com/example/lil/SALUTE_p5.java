package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SALUTE_p5 extends AppCompatActivity implements retrieveTime{
    private String size, activity, location, unit, time;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_1_p6);

        //get previous variable(s)
        Intent getVariable = getIntent();
        size = getVariable.getStringExtra("size");
        activity = getVariable.getStringExtra("activity");
        location = getVariable.getStringExtra("location");
        unit = getVariable.getStringExtra("unit");


        final EditText editText = (EditText) findViewById(R.id.timeField);
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {//record size and go to step three
            time = editText.getText().toString();
            Intent intent = new Intent(SALUTE_p5.this, SALUTE_p6.class);
            //again this is a temp solution
            intent.putExtra("size", size);
            intent.putExtra("activity", activity);
            intent.putExtra("location", location);
            intent.putExtra("unit", unit);
            intent.putExtra("time", time);
            startActivity(intent);
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {//go back to main menu
            Intent intent = new Intent(SALUTE_p5.this, Menu.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//go to step one
            Intent intent = new Intent(SALUTE_p5.this, SALUTE_p4.class);
            startActivity(intent);
        });
    }
    @Override
    public String getTime() { return time; }

}

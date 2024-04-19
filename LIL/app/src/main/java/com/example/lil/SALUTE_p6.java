package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SALUTE_p6 extends AppCompatActivity implements retrieveEquip{
    private String size, activity, location, unit, time, equip;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_1_p7);

        //get previous variable(s)
        Intent getVariable = getIntent();
        size = getVariable.getStringExtra("size");
        activity = getVariable.getStringExtra("activity");
        location = getVariable.getStringExtra("location");
        unit = getVariable.getStringExtra("unit");
        time = getVariable.getStringExtra("time");

        final EditText editText = (EditText) findViewById(R.id.equipField);
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {//record size and go to step three
            equip = editText.getText().toString();
            Intent intent = new Intent(SALUTE_p6.this, ReviewSALUTE.class);
            //again this is a temp solution
            intent.putExtra("size", size);
            intent.putExtra("activity", activity);
            intent.putExtra("location", location);
            intent.putExtra("unit", unit);
            intent.putExtra("time", time);
            intent.putExtra("equip", equip);
            startActivity(intent);
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {//go back to main menu
            Intent intent = new Intent(SALUTE_p6.this, Menu.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//go to step one
            Intent intent = new Intent(SALUTE_p6.this, SALUTE_p5.class);
            startActivity(intent);
        });
    }

    @Override
    public String getEquip() { return equip; }

}

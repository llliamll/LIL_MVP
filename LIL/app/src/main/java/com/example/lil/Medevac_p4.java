package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Medevac_p4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p4);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        CheckBox checkA = findViewById(R.id.noEquip);
        CheckBox checkB = findViewById(R.id.hoist);
        CheckBox checkC = findViewById(R.id.extraction);
        CheckBox checkD = findViewById(R.id.ventilator);


        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p4.this, Medevac_p5.class);
            String line4 = "";
            if(checkA.isChecked()){
                line4 += "A ";
            }
            if(checkB.isChecked()){
                line4 += "B ";
            }
            if(checkC.isChecked()){
                line4 += "C ";
            }
            if(checkD.isChecked()){
                line4 += "D";
            }
            extras.putString("line4", line4);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p4.this, Medevac_p3.class);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p4.this, Menu.class);
            startActivity(intent);
        });
    }
}
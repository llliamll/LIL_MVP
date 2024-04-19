package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Medevac_p6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p6);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        CheckBox checkA = findViewById(R.id.noEnemy);
        CheckBox checkB = findViewById(R.id.possibleEnemy);
        CheckBox checkC = findViewById(R.id.mediumEnemy);
        CheckBox checkD = findViewById(R.id.needEscort);


        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p6.this, Medevac_p7.class);
            String line6 = "";
            if(checkA.isChecked()){
                line6 += checkA.getText().toString();
            }
            if(checkB.isChecked()){
                line6 += checkB.getText().toString();
            }
            if(checkC.isChecked()){
                line6 += checkC.getText().toString();
            }
            if(checkD.isChecked()){
                line6 += checkD.getText().toString();
            }
            extras.putString("line6", line6);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p6.this, Medevac_p5.class);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p6.this, Menu.class);
            startActivity(intent);
        });
    }
}
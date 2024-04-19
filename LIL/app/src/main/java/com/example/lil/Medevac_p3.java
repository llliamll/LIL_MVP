package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class Medevac_p3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p3);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        //set initial values
        TextView numA = findViewById(R.id.textViewCountA);
        AtomicInteger countA = new AtomicInteger(0);
        numA.setText(String.valueOf(countA.get()));

        TextView numB = findViewById(R.id.textViewCountB);
        AtomicInteger countB = new AtomicInteger(0);
        numB.setText(String.valueOf(countB.get()));

        TextView numC = findViewById(R.id.textViewCountC);
        AtomicInteger countC = new AtomicInteger(0);
        numC.setText(String.valueOf(countC.get()));

        TextView numD = findViewById(R.id.textViewCountD);
        AtomicInteger countD = new AtomicInteger(0);
        numD.setText(String.valueOf(countD.get()));

        //use buttons to increase or decrease
        //countA
        Button plusA = findViewById(R.id.buttonPlusA);
        plusA.setOnClickListener(v -> {
            numA.setText(String.valueOf(countA.incrementAndGet()));
        });
        Button minusA = findViewById(R.id.buttonMinusA);
        minusA.setOnClickListener(v -> {
            if(countA.get() > 0){
                numA.setText(String.valueOf(countA.decrementAndGet()));
            }else{
                Toast.makeText(Medevac_p3.this, "Cannot go below zero!", Toast.LENGTH_SHORT).show();
            }
        });

        //countB
        Button plusB = findViewById(R.id.buttonPlusB);
        plusB.setOnClickListener(v -> {
            numB.setText(String.valueOf(countB.incrementAndGet()));
        });
        Button minusB = findViewById(R.id.buttonMinusB);
        minusB.setOnClickListener(v -> {
            if(countB.get() > 0){
                numB.setText(String.valueOf(countB.decrementAndGet()));
            }else{
                Toast.makeText(Medevac_p3.this, "Cannot go below zero!", Toast.LENGTH_SHORT).show();
            }
        });

        //countC
        Button plusC = findViewById(R.id.buttonPlusC);
        plusC.setOnClickListener(v -> {
            numC.setText(String.valueOf(countC.incrementAndGet()));
        });
        Button minusC = findViewById(R.id.buttonMinusC);
        minusC.setOnClickListener(v -> {
            if(countC.get() > 0){
                numC.setText(String.valueOf(countC.decrementAndGet()));
            }else{
                Toast.makeText(Medevac_p3.this, "Cannot go below zero!", Toast.LENGTH_SHORT).show();
            }
        });

        //countD
        Button plusD = findViewById(R.id.buttonPlusD);
        plusD.setOnClickListener(v -> {
            numD.setText(String.valueOf(countD.incrementAndGet()));
        });
        Button minusD = findViewById(R.id.buttonMinusD);
        minusD.setOnClickListener(v -> {
            if(countD.get() > 0){
                numD.setText(String.valueOf(countD.decrementAndGet()));
            }else{
                Toast.makeText(Medevac_p3.this, "Cannot go below zero!", Toast.LENGTH_SHORT).show();
            }
        });

        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p3.this, Medevac_p4.class);
            extras.putString("line3", checkQuantAndSave(numA.getText().toString(), numB.getText().toString(),
                    numC.getText().toString(), numD.getText().toString()));
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p3.this, Medevac_p2.class);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p3.this, Menu.class);
            startActivity(intent);
        });
    }

    //only pass on values greater than 0
    public String checkQuantAndSave(String a, String b, String c, String d){
        String line3 = "";
        if(Integer.valueOf(a) > 0){
            line3 += a + " x A ";
        }
        if(Integer.valueOf(b) > 0){
            line3 += b + " x B ";
        }
        if(Integer.valueOf(c) > 0){
            line3 += c + "x C ";
        }
        if(Integer.valueOf(d) > 0){
            line3 += d + "x D";
        }
        return line3;

    }
}
package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class Medevac_p5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p5);

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
                Toast.makeText(Medevac_p5.this, "Cannot go below zero!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Medevac_p5.this, "Cannot go below zero!", Toast.LENGTH_SHORT).show();
            }
        });

        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p5.this, Medevac_p6.class);
            extras.putString("line5", checkQuantAndSave(numA.getText().toString(), numB.getText().toString()));
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p5.this, Medevac_p4.class);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm back to menu");
            builder.setMessage("All input will be cleared");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Medevac_p5.this, Menu.class);
                    intent.putExtra("name", extras.getString("name"));
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });

        Button save = findViewById(R.id.saveNReview);
        save.setOnClickListener(v -> {
            if(!extras.getBoolean("edit")){
                Toast.makeText(Medevac_p5.this,"You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(Medevac_p5.this, ReviewMedevac.class);
                extras.putString("line5", checkQuantAndSave(numA.getText().toString(), numB.getText().toString()));
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    //only pass on values greater than 0
    public String checkQuantAndSave(String a, String b){
        String line5 = "";
        if(Integer.valueOf(a) > 0){
            line5 += a + " x A <br>";
        }
        if(Integer.valueOf(b) > 0){
            line5 += b + " x B";
        }

        return line5;
    }
}
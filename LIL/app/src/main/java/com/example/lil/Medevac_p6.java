package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
                    Intent intent = new Intent(Medevac_p6.this, Menu.class);
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
                Toast.makeText(Medevac_p6.this,"You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(Medevac_p6.this, ReviewMedevac.class);
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
            }
        });
    }
}
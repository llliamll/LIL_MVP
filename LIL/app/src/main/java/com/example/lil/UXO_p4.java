package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UXO_p4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uxo_p4);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        CheckBox checkA = findViewById(R.id.drop);
        CheckBox checkB = findViewById(R.id.project);
        CheckBox checkC = findViewById(R.id.placed);
        CheckBox checkD = findViewById(R.id.thrown);


        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p4.this, UXO_p5.class);
            String line4 = "";
            if(checkA.isChecked()){
                line4 += "Dropped ";
            }
            if(checkB.isChecked()){
                line4 += "Projected ";
            }
            if(checkC.isChecked()){
                line4 += "Placed ";
            }
            if(checkD.isChecked()){
                line4 += "Thrown";
            }
            extras.putString("line4", line4);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p4.this, UXO_p3.class);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomAlertDialogTheme);
            builder.setTitle("Confirm back to menu");
            builder.setMessage("All input will be cleared");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(UXO_p4.this, Menu.class);
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
                Toast.makeText(UXO_p4.this, "You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(UXO_p4.this, ReviewUXO.class);
                String line4 = "";
                if(checkA.isChecked()){
                    line4 += "Dropped ";
                }
                if(checkB.isChecked()){
                    line4 += "Projected ";
                }
                if(checkC.isChecked()){
                    line4 += "Placed ";
                }
                if(checkD.isChecked()){
                    line4 += "Thrown";
                }
                extras.putString("line4", line4);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
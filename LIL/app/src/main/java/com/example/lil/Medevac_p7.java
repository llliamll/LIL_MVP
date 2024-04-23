package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Medevac_p7 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p7);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        CheckBox checkA = findViewById(R.id.panels);
        CheckBox checkB = findViewById(R.id.pyrotechnic);
        CheckBox checkC = findViewById(R.id.smoke);
        CheckBox checkD = findViewById(R.id.noMarking);
        CheckBox checkE = findViewById(R.id.other);


        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p7.this, Medevac_p8.class);
            String line7 = "";
            if(checkA.isChecked()){
                line7 += "A ";
            }
            if(checkB.isChecked()){
                line7 += "B ";
            }
            if(checkC.isChecked()){
                line7 += "C ";
            }
            if(checkD.isChecked()){
                line7 += "D ";
            }
            if(checkE.isChecked()){
                line7 += "E";
            }
            extras.putString("line7", line7);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p7.this, Medevac_p6.class);
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
                    Intent intent = new Intent(Medevac_p7.this, Menu.class);
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
                Toast.makeText(Medevac_p7.this,"You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(Medevac_p7.this, ReviewMedevac.class);
                String line7 = "";
                if(checkA.isChecked()){
                    line7 += "A ";
                }
                if(checkB.isChecked()){
                    line7 += "B ";
                }
                if(checkC.isChecked()){
                    line7 += "C ";
                }
                if(checkD.isChecked()){
                    line7 += "D ";
                }
                if(checkE.isChecked()){
                    line7 += "E";
                }
                extras.putString("line7", line7);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
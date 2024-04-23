package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UXO_p9 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uxo_p9);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        CheckBox checkA = findViewById(R.id.immediate);
        CheckBox checkB = findViewById(R.id.indirect);
        CheckBox checkC = findViewById(R.id.minor);
        CheckBox checkD = findViewById(R.id.noThreat);

        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p9.this, ReviewUXO.class);
            String line9 = "";
            if(checkA.isChecked()){
                line9 += "Immediate";
            }
            if(checkB.isChecked()){
                line9 += "Indirect";
            }
            if(checkC.isChecked()){
                line9 += "Minor";
            }
            if(checkD.isChecked()){
                line9 += "No Threat";
            }
            extras.putString("line9", line9);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p9.this, UXO_p8.class);
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
                    Intent intent = new Intent(UXO_p9.this, Menu.class);
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
                Toast.makeText(UXO_p9.this, "You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(UXO_p9.this, ReviewUXO.class);
                String line9 = "";
                if(checkA.isChecked()){
                    line9 += checkA.getText().toString();
                }
                if(checkB.isChecked()){
                    line9 += checkB.getText().toString();
                }
                if(checkC.isChecked()){
                    line9 += checkC.getText().toString();
                }
                if(checkD.isChecked()){
                    line9 += checkD.getText().toString();
                }
                extras.putString("line9", line9);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
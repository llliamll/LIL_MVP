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

public class UXO_p3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uxo_p3);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        CheckBox checkA = findViewById(R.id.radio);
        CheckBox checkB = findViewById(R.id.callSign);
        CheckBox checkC = findViewById(R.id.telephone);
        EditText text   = findViewById(R.id.number);

        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p3.this, UXO_p4.class);
            String line3 = "";
            if(checkA.isChecked()){
                line3 += "Radio: ";
            }
            if(checkB.isChecked()){
                line3 += "Call Sign: ";
            }
            if(checkC.isChecked()){
                line3 += "Telephone: ";
            }
            line3 += text.getText().toString();
            extras.putString("line3", line3);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p3.this, UXO_p2.class);
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
                    Intent intent = new Intent(UXO_p3.this, Menu.class);
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
                Toast.makeText(UXO_p3.this, "You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(UXO_p3.this, ReviewUXO.class);
                String line3 = "";
                if(checkA.isChecked()){
                    line3 += "Radio: ";
                }
                if(checkB.isChecked()){
                    line3 += "Call Sign: ";
                }
                if(checkC.isChecked()){
                    line3 += "Telephone: ";
                }
                line3 += text.getText().toString();
                extras.putString("line3", line3);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
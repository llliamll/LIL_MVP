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

public class UXO_p8 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uxo_p8);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        EditText text   = findViewById(R.id.unit);


        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p8.this, UXO_p9.class);
            String line8 = text.getText().toString();
            extras.putString("line8", line8);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(UXO_p8.this, UXO_p7.class);
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
                    Intent intent = new Intent(UXO_p8.this, Menu.class);
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
                Toast.makeText(UXO_p8.this, "You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(UXO_p8.this, ReviewUXO.class);
                String line8 = text.getText().toString();
                extras.putString("line8", line8);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
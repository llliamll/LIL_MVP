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

public class Medevac_p9 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p9);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        //main page functions
        CheckBox checkA = findViewById(R.id.nuclear);
        CheckBox checkB = findViewById(R.id.bio);
        CheckBox checkC = findViewById(R.id.chem);
        EditText other = findViewById(R.id.otherContamination);


        //next back and menu buttons
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p9.this, ReviewMedevac.class);
            String line9 = "";
            if(checkA.isChecked()){
                line9 += "A ";
            }
            if(checkB.isChecked()){
                line9 += "B ";
            }
            if(checkC.isChecked()){
                line9 += "C ";
            }
            if(!other.getText().toString().isEmpty()){
                line9 += other.getText().toString();
            }
            extras.putString("line9", line9);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p9.this, Medevac_p8.class);
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
                    Intent intent = new Intent(Medevac_p9.this, Menu.class);
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
                Toast.makeText(Medevac_p9.this,"You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(Medevac_p9.this, ReviewMedevac.class);
                String line9 = "";
                if(checkA.isChecked()){
                    line9 += "A ";
                }
                if(checkB.isChecked()){
                    line9 += "B ";
                }
                if(checkC.isChecked()){
                    line9 += "C ";
                }
                if(!other.getText().toString().isEmpty()){
                    line9 += other.getText().toString();
                }
                extras.putString("line9", line9);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
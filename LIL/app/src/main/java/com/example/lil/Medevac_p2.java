package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Medevac_p2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p2);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        // set default values
        EditText freq = findViewById(R.id.radioField);
        freq.setText("Default radio frequency");
        freq.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText) v;
                if (hasFocus) {
                    if("Default radio frequency".equals(et.getText().toString())){
                        et.setText("");
                    }
                }else{
                    if(et.getText().toString().isEmpty()) {
                        et.setText("Default radio frequency");
                    }
                }
            }
        });

        EditText callSign = findViewById(R.id.callSignField);
        callSign.setText("Default CALL SIGN");
        callSign.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText) v;
                if (hasFocus) {
                    if("Default CALL SIGN".equals(et.getText().toString())){
                        et.setText("");
                    }
                }else{
                    if(et.getText().toString().isEmpty()) {
                        et.setText("Default CALL SIGN");
                    }
                }
            }
        });

        EditText suffix = findViewById(R.id.suffixField);
        suffix.setText("Default suffix");
        suffix.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText) v;
                if (hasFocus) {
                    if("Default suffix".equals(et.getText().toString())){
                        et.setText("");
                    }
                }else{
                    if(et.getText().toString().isEmpty()) {
                        et.setText("Default suffix");
                    }
                }
            }
        });

        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p2.this, Medevac_p3.class);
            String line2 = freq.getText().toString() + " / " + callSign.getText().toString() + " / " + suffix.getText().toString();
            extras.putString("line2", line2);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p2.this, Medevac.class);
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
                    Intent intent = new Intent(Medevac_p2.this, Menu.class);
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
                Toast.makeText(Medevac_p2.this,"You have not complete other required fields yet", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(Medevac_p2.this, ReviewMedevac.class);
                String line2 = freq.getText().toString() + " / " + callSign.getText().toString() + " / " + suffix.getText().toString();
                extras.putString("line2", line2);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
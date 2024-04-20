package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SALUTE_p2 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salute_p2);

        //get the bundle
        Bundle extras = getIntent().getExtras();

        final EditText editText = findViewById(R.id.activityField);
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {//record size and go to step three
            Intent intent = new Intent(SALUTE_p2.this, SALUTE_p3.class);
            extras.putString("activity", editText.getText().toString());
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm back to menu");
            builder.setMessage("All input will be cleared");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(SALUTE_p2.this, Menu.class);
                    intent.putExtra("name", extras.getString("name"));
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//go to step one
            Intent intent = new Intent(SALUTE_p2.this, SALUTE.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
    }
}

package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Medevac extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p1);

        EditText loc = findViewById(R.id.locField);

        Intent getExtras = getIntent();
        Bundle extras = getExtras.getExtras();

        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac.this, Medevac_p2.class);
            extras.putString("line1",loc.getText().toString());
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac.this, Menu.class);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac.this, Menu.class);
            startActivity(intent);
        });
    }
}
package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SALUTE extends AppCompatActivity implements retrieveSize {
    private String size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_1_p2);

        Bundle extras = getIntent().getExtras();

        final EditText editText = (EditText) findViewById(R.id.sizeField);
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {//record size and go to step three
            size = editText.getText().toString();
            Intent intent = new Intent(SALUTE.this, SALUTE_p2.class);
//            intent.putExtra("size", size);// this is a temporary solution to pass on variables
            extras.putString("size", editText.getText().toString());
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {//go back to main menu
            Intent intent = new Intent(SALUTE.this, Menu.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//go to step one
            Intent intent = new Intent(SALUTE.this, Menu.class);
            startActivity(intent);
        });
    }
    @Override
    public String getSize() { return size; }
}
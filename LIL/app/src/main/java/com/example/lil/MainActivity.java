package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText name = findViewById(R.id.username);
        //save the entered name and go to next page
        Button buttonNext = findViewById(R.id.login);
        buttonNext.setOnClickListener( v-> {//record name and go to step two
            Intent intent = new Intent(MainActivity.this, Menu.class);
            intent.putExtra("name", name.getText().toString());
            startActivity(intent);
        });

        //toggle night mode
        Button nightMode = findViewById(R.id.nightMode);
        nightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int night = AppCompatDelegate.getDefaultNightMode();
                if (night == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
            }
        });
    }
}
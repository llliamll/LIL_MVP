package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_1_p1);

        EditText name = (EditText) findViewById(R.id.username);
        //save the entered name and go to next page
        Button buttonNext = findViewById(R.id.login);
        buttonNext.setOnClickListener( v-> {//record name and go to step two
            Intent intent = new Intent(MainActivity.this, PageOneActivity.class);
            intent.putExtra("username", name.getText().toString());
            startActivity(intent);
        });


    }
}
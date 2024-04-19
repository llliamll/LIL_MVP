package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SALUTE_p2 extends AppCompatActivity implements retrieveActivity{
    private String size, activity;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_1_p3);

        //get previous variable(s)
//        Intent getVariable = getIntent();
//        size = getVariable.getStringExtra("size");
        Bundle extras = getIntent().getExtras();

        final EditText editText = (EditText) findViewById(R.id.activityField);
        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {//record size and go to step three
            activity = editText.getText().toString();
            Intent intent = new Intent(SALUTE_p2.this, SALUTE_p3.class);
            //again this is a temp solution
            intent.putExtra("size", size);
            intent.putExtra("activity", activity);
            startActivity(intent);
        });

        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(v -> {//go back to main menu
            Intent intent = new Intent(SALUTE_p2.this, Menu.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {//go to step one
            Intent intent = new Intent(SALUTE_p2.this, SALUTE.class);
            startActivity(intent);
        });
    }
    @Override
    public String getActivity() { return activity; }


}

package com.example.lil;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.Button;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = new Bundle();

        //display name
        TextView username = findViewById(R.id.menuUsername);
        String name = getIntent().getStringExtra("name");
        String text = "Welcome <b>" + name + "</b>";
        username.setText(Html.fromHtml(text,Html.FROM_HTML_MODE_LEGACY));
        extras.putString("name", name);


        //go to report 1
        Button buttonReportOne = findViewById(R.id.buttonPageOne);
        buttonReportOne.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, SALUTE.class);
            intent.putExtras(extras);
            startActivity(intent);
        });

        //go to report MEDEVAC
        Button medevac = findViewById(R.id.buttonPageSix);
        medevac.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, Medevac.class);
            intent.putExtras(extras);
            startActivity(intent);
        });

        //go to report UXO
        Button buttonReportFive = findViewById(R.id.buttonPageFive);
        buttonReportFive.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, UXO.class);
            intent.putExtras(extras);
            startActivity(intent);
        });

        //view existing report(s)
        Button view = findViewById(R.id.viewReport);
        view.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, viewReport.class);
            intent.putExtras(extras);
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


        //display a message for other not yet implemented reports
        Button buttonReportTwo = findViewById(R.id.buttonPageTwo);
        otherButtons(buttonReportTwo);
        Button buttonReportThree = findViewById(R.id.buttonPageThree);
        otherButtons(buttonReportThree);
        Button buttonReportFour = findViewById(R.id.buttonPageFour);
        otherButtons(buttonReportFour);
    }

    private void otherButtons(Button button){
        button.setOnClickListener(v -> {
            Toast.makeText(Menu.this, "Not Yet Implemented...", Toast.LENGTH_SHORT).show();
        });
    }


}
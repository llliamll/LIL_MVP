package com.example.lil;

import java.util.*;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class viewReport extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_report);
        Bundle extras = getIntent().getExtras();
        ListView listReport = findViewById(R.id.listReport);
        TextView reportContent  = findViewById(R.id.viewReportContent);
        reportContent.setMovementMethod(new ScrollingMovementMethod());

        //list existing reports and display only txt files
        String[] fileList = fileList();
        List<String> txtFiles = new ArrayList<>();
        for (String file : fileList) {
            if (file.endsWith(".txt")) {
                txtFiles.add(file);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                txtFiles.toArray(new String[0]));

        listReport.setAdapter(adapter);

        //get content
        listReport.setOnItemClickListener(((parent, view, position, id) -> {
            StringBuilder sb = new StringBuilder();
            String fileName = txtFiles.get(position);
            try(FileInputStream fis = openFileInput(fileName);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr)){
                String line;
                while ((line = reader.readLine()) != null){
                    sb.append(line).append('\n');
                }
            } catch (IOException e){
                Toast.makeText(this, "Error reading report", Toast.LENGTH_SHORT).show();
            }

            //display
            reportContent.setText(sb);
        }));


        //back to menu, inputs will be cleared
        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(viewReport.this, Menu.class);
            intent.putExtra("name",extras.getString("name"));
            startActivity(intent);
        });

    }
}


package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import android.util.Log;

public class ReviewMedevac extends AppCompatActivity{

    private String reportName, name, line1, line2, line3, line4, line5, line6, line7, line8, line9;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_medevac);


        //get all input information
        Intent savedData = getIntent();
        Bundle extras = savedData.getExtras();
        reportName = "<b>Medevac Report</b>";
        name  = "<b>Name:  </b>" + extras.getString("name");
        line1 = "<b>LINE1: </b>" + extras.getString("line1");
        line2 = "<b>LINE2: </b>" + extras.getString("line2");
        line3 = "<b>LINE3: </b>" + extras.getString("line3");
        line4 = "<b>LINE4: </b>" + extras.getString("line4");
        line5 = "<b>LINE5: </b>" + extras.getString("line5");
        line6 = "<b>LINE6: </b>" + extras.getString("line6");
        line7 = "<b>LINE7: </b>" + extras.getString("line7");
        line8 = "<b>LINE8: </b>" + extras.getString("line8");
        line9 = "<b>LINE9: </b>" + extras.getString("line9");

        //display on screen
        TextView tv1 = findViewById(R.id.line1);
        tv1.setText(Html.fromHtml(line1,Html.FROM_HTML_MODE_LEGACY));
        TextView tv2 = findViewById(R.id.line2);
        tv2.setText(Html.fromHtml(line2,Html.FROM_HTML_MODE_LEGACY));
        TextView tv3 = findViewById(R.id.line3);
        tv3.setText(Html.fromHtml(line3,Html.FROM_HTML_MODE_LEGACY));
        TextView tv4 = findViewById(R.id.line4);
        tv4.setText(Html.fromHtml(line4,Html.FROM_HTML_MODE_LEGACY));
        TextView tv5 = findViewById(R.id.line5);
        tv5.setText(Html.fromHtml(line5,Html.FROM_HTML_MODE_LEGACY));
        TextView tv6 = findViewById(R.id.line6);
        tv6.setText(Html.fromHtml(line6,Html.FROM_HTML_MODE_LEGACY));
        TextView tv7 = findViewById(R.id.line7);
        tv7.setText(Html.fromHtml(line7,Html.FROM_HTML_MODE_LEGACY));
        TextView tv8 = findViewById(R.id.line8);
        tv8.setText(Html.fromHtml(line8,Html.FROM_HTML_MODE_LEGACY));
        TextView tv9 = findViewById(R.id.line9);
        tv9.setText(Html.fromHtml(line9,Html.FROM_HTML_MODE_LEGACY));

        //TODO: implement going back to specific page and change info
        // Note: going back to specific page is very easy to do, just need figure out how to make the previous inputs stay there
        // maybe I can pass the info back to these pages again using intent.putExtra()
        Button b1 = findViewById(R.id.line1BUtton);
        otherButtons(b1);
        Button b2 = findViewById(R.id.line2Button);
        otherButtons(b2);
        Button b3 = findViewById(R.id.line3Button);
        otherButtons(b3);
        Button b4 = findViewById(R.id.line4Button);
        otherButtons(b4);
        Button b5 = findViewById(R.id.line5Button);
        otherButtons(b5);
        Button b6 = findViewById(R.id.line6Button);
        otherButtons(b6);
        Button b7 = findViewById(R.id.line7Button);
        otherButtons(b7);
        Button b8 = findViewById(R.id.line8Button);
        otherButtons(b8);
        Button b9 = findViewById(R.id.line9Button);
        otherButtons(b9);

        Button submit = findViewById(R.id.submitReport);
        submit.setOnClickListener(v -> {
            Toast.makeText(ReviewMedevac.this, "Sending report", Toast.LENGTH_SHORT).show();
            writeReport();
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Menu.class);
            intent.putExtra("name", extras.getString("name"));
            startActivity(intent);
        });
    }

    private void otherButtons(Button button){
        button.setOnClickListener(v -> {
            Toast.makeText(ReviewMedevac.this, "Not Yet Implemented...", Toast.LENGTH_SHORT).show();
        });
    }

    private void writeReport() {
        String fileName = "MedevacReport.txt";
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            outputStreamWriter.write(Html.fromHtml(reportName, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(name,  Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line1, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line2, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line3, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line4, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line5, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line6, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line7, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line8, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(line9, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            Toast.makeText(this, "Failed to save report", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                Log.e("WriteFile", "Error closing file: " + e.toString());
            }
        }

    }
}


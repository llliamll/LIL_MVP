package com.example.lil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
        line3 = "<b>LINE3: </b><div>" + extras.getString("line3") + "</div>";
        line4 = "<b>LINE4: </b>" + extras.getString("line4");
        line5 = "<b>LINE5: </b><div>" + extras.getString("line5") + "</div>";
        line6 = "<b>LINE6: </b>" + extras.getString("line6");
        line7 = "<b>LINE7: </b>" + extras.getString("line7");
        line8 = "<b>LINE8: </b><div>" + extras.getString("line8") + "</div>";
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

        //-------------edit input buttons------------------
        Button b1 = findViewById(R.id.line1BUtton);
        b1.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b2 = findViewById(R.id.line2Button);
        b2.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p2.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b3 = findViewById(R.id.line3Button);
        b3.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p3.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b4 = findViewById(R.id.line4Button);
        b4.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p4.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b5 = findViewById(R.id.line5Button);
        b5.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p5.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b6 = findViewById(R.id.line6Button);
        b6.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p6.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b7 = findViewById(R.id.line7Button);
        b7.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p7.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b8 = findViewById(R.id.line8Button);
        b8.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p8.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button b9 = findViewById(R.id.line9Button);
        b9.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewMedevac.this, Medevac_p9.class);
            extras.putBoolean("edit", true);
            intent.putExtras(extras);
            startActivity(intent);
        });
        //-------------edit input------------------

        //submit the reports
        //NOTE: for this MPV, submit only saves a report since we don't really
        //have the functionality of communicating
        Button submit = findViewById(R.id.submitReport);
        submit.setOnClickListener(v -> {
            Toast.makeText(ReviewMedevac.this, "Sending report", Toast.LENGTH_SHORT).show();
            writeReport();
        });

        //back to menu, inputs will be cleared
        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm back to menu");
            builder.setMessage("All input will be cleared");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(ReviewMedevac.this, Menu.class);
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


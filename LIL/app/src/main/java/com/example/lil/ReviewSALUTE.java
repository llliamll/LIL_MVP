package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// right now this page is hardcoded(ish) that only support displaying report one items
// for future this should be dynamic and display other reports' items

public class ReviewSALUTE extends AppCompatActivity{

    private String reportName, name, size, activity, location, unit, time, equip;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_n_submit);

        Bundle extras = getIntent().getExtras();

        //get all input information
        reportName = "<b>SALUTE report</b>";
        name     = "<b>Name:      </b>" + extras.getString("name");
        size     = "<b>Size:      </b>" + extras.getString("size");
        activity = "<b>Activity:  </b>" + extras.getString("activity");
        location = "<b>Location:  </b>" + extras.getString("location");
        unit     = "<b>Uniform:   </b>" + extras.getString("unit");
        time     = "<b>Time:      </b>" + extras.getString("time");
        equip    = "<b>Equipment: </b>" + extras.getString("equip");

        //display user input on screen
        TextView tv1 = findViewById(R.id.sizeReview);
        tv1.setText(Html.fromHtml(size,Html.FROM_HTML_MODE_LEGACY));
        TextView tv2 = findViewById(R.id.activityReview);
        tv2.setText(Html.fromHtml(activity,Html.FROM_HTML_MODE_LEGACY));
        TextView tv3 = findViewById(R.id.locationReview);
        tv3.setText(Html.fromHtml(location,Html.FROM_HTML_MODE_LEGACY));
        TextView tv4 = findViewById(R.id.unitReview);
        tv4.setText(Html.fromHtml(unit,Html.FROM_HTML_MODE_LEGACY));
        TextView tv5 = findViewById(R.id.timeReview);
        tv5.setText(Html.fromHtml(time,Html.FROM_HTML_MODE_LEGACY));
        TextView tv6 = findViewById(R.id.equipReview);
        tv6.setText(Html.fromHtml(equip,Html.FROM_HTML_MODE_LEGACY));


        //-------------edit input buttons------------------
        Button editSize = findViewById(R.id.editSize);
        editSize.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, SALUTE.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button editActivity = findViewById(R.id.editActivity);
        editActivity.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, SALUTE_p2.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button editLocation = findViewById(R.id.editLocation);
        editLocation.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, SALUTE_p3.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button editUnit = findViewById(R.id.editUnit);
        editUnit.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, SALUTE_p4.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button editTime = findViewById(R.id.editTime);
        editTime.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, SALUTE_p5.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        Button editEquip = findViewById(R.id.editEquip);
        editEquip.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, SALUTE_p6.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        //-------------edit input------------------

        //submit the reports
        //NOTE: for this MPV, submit only saves a report since we don't really
        //have the functionality of communicating
        Button submit = findViewById(R.id.submitReport);
        submit.setOnClickListener(v -> {
            Toast.makeText(ReviewSALUTE.this, "Sending report", Toast.LENGTH_SHORT).show();
            writeReport();
        });

        //back to menu, inputs will be cleared
        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, Menu.class);
            intent.putExtra("name",name);
            startActivity(intent);
        });
    }

    private void writeReport() {
        String fileName = "SALUTE.txt";
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            outputStreamWriter.write(Html.fromHtml(reportName, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(name,  Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(size, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(activity, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(location, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(unit, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(time, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");
            outputStreamWriter.write(Html.fromHtml(equip, Html.FROM_HTML_MODE_LEGACY).toString() + "\n");

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


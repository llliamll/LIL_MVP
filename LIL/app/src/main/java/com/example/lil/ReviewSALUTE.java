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

    private String size, activity, location, unit, time, equip;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_n_submit);

        //this is not working... im too lazy to fix now, might comeback later
//        size     = "Size: "         + new ReportOneStepTwo().getSize();
//        activity = "Activity: "     + new ReportOneStepThree().getActivity();
//        location = "Location: "     + new ReportOneStepFour().getLocation();
//        unit     = "Uniform/Unit: " + new ReportOneStepFive().getUnit();
//        time     = "Time: "         + new ReportOneStepSix().getTime();
//        equip    = "Equipment: "    + new ReportOneStepSeven().getEquip();

        //get all input information
        Intent getVariable = getIntent();
        size     = "<b>Size: </b>"      + getVariable.getStringExtra("size");
        activity = "<b>Activity: </b>"  + getVariable.getStringExtra("activity");
        location = "<b>Location: </b>"  + getVariable.getStringExtra("location");
        unit     = "<b>Uniform: </b>"   + getVariable.getStringExtra("unit");
        time     = "<b>Time: </b>"      + getVariable.getStringExtra("time");
        equip    = "<b>Equipment: </b>" + getVariable.getStringExtra("equip");

        //display on screen
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

        //TODO: implement going back to specific page and change info
        // Note: going back to specific page is very easy to do, just need figure out how to make the previous inputs stay there
        // maybe I can pass the info back to these pages again using intent.putExtra()
        Button editSize = findViewById(R.id.editSize);
        otherButtons(editSize);
        Button editActivity = findViewById(R.id.editActivity);
        otherButtons(editActivity);
        Button editLocation = findViewById(R.id.editLocation);
        otherButtons(editLocation);
        Button editUnit = findViewById(R.id.editUnit);
        otherButtons(editUnit);
        Button editTime = findViewById(R.id.editTime);
        otherButtons(editTime);
        Button editEquip = findViewById(R.id.editEquip);
        otherButtons(editEquip);
        Button submit = findViewById(R.id.submitReport);
        submit.setOnClickListener(v -> {
            Toast.makeText(ReviewSALUTE.this, "Sending report", Toast.LENGTH_SHORT).show();
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewSALUTE.this, Menu.class);
            startActivity(intent);
        });
    }

    private void otherButtons(Button button){
        button.setOnClickListener(v -> {
            Toast.makeText(ReviewSALUTE.this, "Not Yet Implemented...", Toast.LENGTH_SHORT).show();
        });
    }

    private void writeReport() {
        String fileName = "SALUTE.txt";
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);

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


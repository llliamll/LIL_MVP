package com.example.lil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Medevac_p2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medevac_p2);

        //retrieve previous data
        Intent intentFromLast = getIntent();
        Bundle extras = intentFromLast.getExtras();

        // set default values
        EditText freq = findViewById(R.id.radioField);
        freq.setText("Default radio frequency");
        freq.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText) v;
                if (hasFocus) {
                    if("Default radio frequency".equals(et.getText().toString())){
                        et.setText("");
                    }
                }else{
                    if(et.getText().toString().isEmpty()) {
                        et.setText("Default radio frequency");
                    }
                }
            }
        });

        EditText callSign = findViewById(R.id.callSignField);
        callSign.setText("Default CALL SIGN");
        callSign.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText) v;
                if (hasFocus) {
                    if("Default CALL SIGN".equals(et.getText().toString())){
                        et.setText("");
                    }
                }else{
                    if(et.getText().toString().isEmpty()) {
                        et.setText("Default CALL SIGN");
                    }
                }
            }
        });

        EditText suffix = findViewById(R.id.suffixField);
        suffix.setText("Default suffix");
        suffix.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText et = (EditText) v;
                if (hasFocus) {
                    if("Default suffix".equals(et.getText().toString())){
                        et.setText("");
                    }
                }else{
                    if(et.getText().toString().isEmpty()) {
                        et.setText("Default suffix");
                    }
                }
            }
        });

        Button next = findViewById(R.id.Next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p2.this, Medevac_p3.class);
//            if(freq.getText().toString().isEmpty()){
//                extras.putString("frequency", "Default Frequency");
//            }else{
//                extras.putString("frequency", freq.getText().toString());
//            }
//
//            if(callSign.getText().toString().isEmpty()){
//                extras.putString("callSign", "Default CALL SIGN");
//            }else{
//                extras.putString("callSign", callSign.getText().toString());
//            }
//
//            if(suffix.getText().toString().isEmpty()){
//                extras.putString("suffix", "Default suffix");
//            }else{
//                extras.putString("suffix", suffix.getText().toString());
//            }
//
            String line2 = freq.getText().toString() + " / " + callSign.getText().toString() + " / " + suffix.getText().toString();
            extras.putString("line2", line2);
            intent.putExtras(extras);
            startActivity(intent);
        });

        Button back = findViewById(R.id.Back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p2.this, Medevac.class);
            startActivity(intent);
        });

        Button menu = findViewById(R.id.backToMenu);
        menu.setOnClickListener(v -> {
            Intent intent = new Intent(Medevac_p2.this, Menu.class);
            startActivity(intent);
        });
    }
}
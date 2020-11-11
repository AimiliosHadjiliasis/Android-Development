package com.example.explicitintentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    //Set components:
    TextView tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Link Components:
        tvWelcome = findViewById(R.id.tvWelcome);

        //Get Data from main activity using the intent
        //Since we are pass string here then we need to use the getStringExtra
        //inside that we pass the key
        String name = getIntent().getStringExtra("data_name");

        //Set Text to Text View:
        tvWelcome.setText(name + " ,  welcome to activity 2");

    }
}
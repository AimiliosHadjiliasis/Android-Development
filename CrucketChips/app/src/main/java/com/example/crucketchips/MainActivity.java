package com.example.crucketchips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Set up components:
    EditText etChirps;
    Button btCalculate;
    TextView tvResults;

    //Cut decimals
    DecimalFormat formater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link them together:
        etChirps = findViewById(R.id.etChirps);
        btCalculate=findViewById(R.id.btCalculate);
        tvResults=findViewById(R.id.tvResults);

        //Set visibility of text view to false:
        tvResults.setVisibility(View.GONE);

        //set formatter to cut decimals:
        //This will keep 2 decimals
        formater = new DecimalFormat("#0.00");

        //Listener for button
        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check if user has actually type something
                if (etChirps.getText().toString().isEmpty())
                {
                    //Give error message using toast:
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temperature = (chirps/3.0)+4;

                    String results = "The approximate temperature is:" + formater.format(temperature) + "degrees Celsius.";
                    tvResults.setText(results);
                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
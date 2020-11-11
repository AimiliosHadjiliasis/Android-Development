package com.example.explicitintentapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Setup components:
    EditText etName;
    Button btnAct2;
    Button btnAct3;
    TextView tvResults;

    //Initialise Activity 3 key to make it more readable:
    //Its used when we open the activity 3 for requesting data method
    final int ACTIVITY3 = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link Components:
        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);

        //Create Button Listener for Activity 2:
        //Send name to Activity 2:
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If user enter something to name:
                if (etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter name",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Get name from text
                    String name = etName.getText().toString().trim();

                    //Open a new activity:
                    //To do that we need to create a new intent
                    //Inside that intent we pass first the activity we are and then the activity
                    //that we want to go with its full name
                    Intent intent = new Intent(MainActivity.this,
                            com.example.explicitintentapplication.Activity2.class);

                    //We want to sent data to this intent:
                    intent.putExtra("data_name", name);

                    //Then we start the new activity:
                    startActivity(intent);
                }

            }
        });

        //Create Button Listener for Activity 3:
        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.explicitintentapplication.Activity3.class);

                //Start the activity to request data
                //we first pass the intent and then we pass a key which will uniquely identify
                //the activity 3.
                startActivityForResult(intent, ACTIVITY3);
            }
        });
    }
        //Method that help us to get data back:

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            //WAY TO IDENTIFY FROM WHERE DATA ARE COMING:
            if (requestCode == ACTIVITY3)
            {
                //RECEIVE DATA FROM ACTIVITY 3:
                if (resultCode == RESULT_OK)
                {
                    tvResults.setText(data.getStringExtra("data_surname"));
                }

                //GO TO ACTIVITY 3 BUT PRESS THE BACK BUTTON AND DO NOT RECEIVE ANY DATA:
                if (resultCode == RESULT_CANCELED)
                {
                    tvResults.setText("No data received");
                }
            }
        }

}
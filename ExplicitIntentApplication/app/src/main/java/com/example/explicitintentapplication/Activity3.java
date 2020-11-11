package com.example.explicitintentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class Activity3 extends AppCompatActivity {

    //SetUp Components:
    EditText etSurname;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //Link Components:
        etSurname = findViewById(R.id.etSurname);
        btnSubmit = findViewById(R.id.btnSubmit);

        //Setup Listener:
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etSurname.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this,"Please Enter a Surname",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String surname = etSurname.getText().toString().trim();

                    //We create an intent so we can pass data back to Main activity:
                    Intent intent = new Intent();
                    intent.putExtra("data_surname", surname);

                    //Since we open this activity to get results we need to set the results
                    //before return them back.
                    setResult(RESULT_OK, intent);

                    //then we need to finish the activity:
                    Activity3.this.finish();
                }
            }
        });
    }
}
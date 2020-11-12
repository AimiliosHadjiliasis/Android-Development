package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity implements View.OnClickListener {

    //Setup components:
    EditText etName, etLocation, etWeb, etNumber;
    ImageView ivSad, ivHappy, ivOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        //Link:
        etName = findViewById(R.id.etName);
        etWeb = findViewById(R.id.etWeb);
        etLocation = findViewById(R.id.etLocation);
        etNumber = findViewById(R.id.etNumber);
        ivSad = findViewById(R.id.ivSad);
        ivOK = findViewById(R.id.ivOK);
        ivHappy = findViewById(R.id.ivHappy);

        //Since we are implementing the onclicklistener method we need tho initialise the images/buttons to this:
        ivSad.setOnClickListener(this);
        ivOK.setOnClickListener(this);
        ivHappy.setOnClickListener(this);

    }

    //Override the click method:
    @Override
    public void onClick(View v) {
        //See if the texts are completed:
        if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty()
        || etLocation.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please Enter All the Fields", Toast.LENGTH_SHORT).show();
        }
        else    // Sent data to main activity
        {
            //Create the intent and add extra inside that intent:
            Intent intent = new Intent();
            intent.putExtra("data_name", etName.getText().toString().trim());
            intent.putExtra("data_number", etNumber.getText().toString().trim());
            intent.putExtra("data_web", etWeb.getText().toString().trim());
            intent.putExtra("data_location", etLocation.getText().toString().trim());

            //We need to know which image is selected:
            if (v.getId() == R.id.ivHappy)
            {
                intent.putExtra("data_mood", "happy");

            }
            else if (v.getId() == R.id.ivSad)
            {
                intent.putExtra("data_mood", "sad");
            }
            else if (v.getId() == R.id.ivOK)
            {
                intent.putExtra("data_mood", "ok");
            }

            //Pass the results to the main activity:
            setResult(RESULT_OK, intent);
            CreateContact.this.finish();
        }
    }
}
package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Setup components:
    ImageView ivMood, ivLocation, ivWeb, ivPhone;
    Button btnCreate;
    String name = "", number = "", web="",location="",mood="";

    //Activity's request code:
    final int CREATE_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link:
        ivMood = findViewById(R.id.ivMood);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocation = findViewById(R.id.ivLocation);
        btnCreate = findViewById(R.id.btnCreate);

        //Hide images:
        ivLocation.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivMood.setVisibility(View.GONE);

        //Create Listener for create Button and Phone/Web/Location Image:
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create intent to open Create Contact:
                Intent intent = new Intent(MainActivity.this,
                        com.example.intentschallenge.CreateContact.class);

                //Start the activity:
                startActivityForResult(intent, CREATE_CONTACT);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web));
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(intent);
            }
        });
    }

    //Create a Receive method:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_CONTACT)
        {
            //CheCk if result get all the info:
            if (resultCode==RESULT_OK)
            {
                //Make the images visible:
                ivLocation.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);


                //Initialise the data that we received back from the create contact activity:
                name = data.getStringExtra("data_name");
                number = data.getStringExtra("data_number");
                web=data.getStringExtra("data_web");
                location=data.getStringExtra("data_location");
                mood = data.getStringExtra("data_mood");

                //Change the mood image
                if (mood == "happy")
                {
                    ivMood.setImageResource(R.drawable.happy);
                }
                else if (mood =="ok")
                {
                    ivMood.setImageResource(R.drawable.ok);
                }
                else if (mood == "sad")
                {
                    ivMood.setImageResource(R.drawable.sad);
                }

                ivMood.setVisibility(View.VISIBLE);
            }
            else
            {
                Toast.makeText(this, "No data passed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

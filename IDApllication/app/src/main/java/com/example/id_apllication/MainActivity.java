package com.example.id_apllication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Setup components
    EditText etID;
    Button btSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect Variables that are set above to the components on XML file:
        etID = findViewById(R.id.etID);
        btSubmit = findViewById(R.id.btSubmit);
        tvResults = findViewById(R.id.tvResults);

        //We need to get the data from the text view when we press the button.
        //to do that we need a listener as follows:
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the text -> Convert to string -> Remove Spaces
                String idNumber = etID.getText().toString().trim();

                //Take 6 first digits -> Save it as the date of Birth:
                String dob =idNumber.substring(0,6);

                //Take next digit to define the gender. Since we need to compare that
                // digit we make it Integer. As it comes from a sting we convert the char to STRING
                // and then we parse it to integer:
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String strGender;

                //Initialise if its M/F
                if (gender < 5)
                    strGender = getString(R.string.famele);
                else
                    strGender = getString(R.string.male);

                //find citizenship. We need the 10th char
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String strNationality;

                //Determine nationality:
                if (nationality == 0)
                    strNationality = getString(R.string.sacitizen);
                else
                    strNationality = getString(R.string.permanentCitizen);

                //Here we present the results to the text view
                //However ww need to add all the text inside a string and then set the text that we
                //want to the tvResults
                String presentedText = getString(R.string.dob) + dob + getString(R.string.newline)
                        + getString(R.string.gender) + strGender + getString(R.string.newline)
                        + getString(R.string.nationality) + strNationality +getString(R.string.newline);

                //Set the text to the Results text view
                tvResults.setText(presentedText);

            }
        });
    }
}
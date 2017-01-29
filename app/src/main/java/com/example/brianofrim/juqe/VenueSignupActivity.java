package com.example.brianofrim.juqe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VenueSignupActivity extends AppCompatActivity {
    EditText venueNameEditText;
    EditText venueCodeEditText;
    Button createButton;
    String venueName;
    String venueCode;
    VenueController venueController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_signup);

        createButton = (Button) findViewById(R.id.createVenueButton);
        venueCodeEditText = (EditText) findViewById(R.id.venueCode);
        venueNameEditText = (EditText) findViewById(R.id.venueName);

        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                venueCode = venueCodeEditText.getText().toString();
                venueName = venueNameEditText.getText().toString();
                venueController.createVenue(venueCode, venueName);
            }
        });
    }
}

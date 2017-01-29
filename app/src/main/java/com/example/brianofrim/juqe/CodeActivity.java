package com.example.brianofrim.juqe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CodeActivity extends Activity {
    private EditText venueCode;
    private TextView venueText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        final Button submitCodeButton = (Button) findViewById(R.id.codeButton);

        venueCode = (EditText) findViewById(R.id.code_edit_text);
        submitCodeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                String codeText = venueCode.getText().toString();
                UserController.setCode(codeText);
                Intent intent;
                intent =  new Intent(CodeActivity.this, UserView.class);
                intent.putExtra("code", codeText);
                startActivity(intent);
            }
        });

        venueText = (TextView) findViewById(R.id.createVenue);
        venueText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CodeActivity.this, VenueSignupActivity.class);
                startActivity(intent);
            }
        });



    }
}

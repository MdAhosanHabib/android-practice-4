package com.example.ahosanhabib.logindatabaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity implements View.OnClickListener {
    private EditText nameED,emailED,usernameED,passwordED;
    private Button signupbtn;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameED = findViewById(R.id.regnameEditTextID);
        emailED = findViewById(R.id.regemailEditTextID);
        usernameED = findViewById(R.id.regusernameEditTextID);
        passwordED = findViewById(R.id.regpasswordEditTextID);
        signupbtn = findViewById(R.id.regsignupbuttonID);

        databaseHelper = new DatabaseHelper(this);
        userDetails = new UserDetails();
        signupbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameED.getText().toString();
        String email = emailED.getText().toString();
        String ussername = usernameED.getText().toString();
        String password = passwordED.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(ussername);
        userDetails.setPassword(password);

        long rowID = databaseHelper.insertData(userDetails);

        if(rowID>0){
            Toast.makeText(getApplicationContext(),"Row: "+rowID+" is successfully filled",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Row insertion is failed",Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.ahosanhabib.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText useredittext, passwordedittext;
    private Button button;
    private TextView textView;
    private int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useredittext = findViewById(R.id.usernameID);
        passwordedittext = findViewById(R.id.passwordID);
        button = findViewById(R.id.buttonID);
        textView = findViewById(R.id.textviewID);
        textView.setText("Number of incorretc attempts: 3");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = useredittext.getText().toString();
                String pass = passwordedittext.getText().toString();

                if(user.equals("admin") && pass.equals("1234")){
                    Intent intent = new Intent(MainActivity.this,secondactivity.class);
                    startActivity(intent);
                }else{
                    counter--;
                    textView.setText("Number of incorretc attempts: "+counter);
                    if(counter==0){
                        button.setEnabled(false);
                    }
                }
            }
        });
    }
}

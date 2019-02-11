package com.example.ahosanhabib.sharedpreferenceuserdetails;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button savebutton, loadbutton;
    private EditText usernametext, passwordtext;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savebutton = findViewById(R.id.savebuttonID);
        loadbutton = findViewById(R.id.loadbuttonID);
        usernametext = findViewById(R.id.usernameID);
        passwordtext = findViewById(R.id.passwordID);
        textView = findViewById(R.id.textviewID);

        savebutton.setOnClickListener(this);
        loadbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.savebuttonID){

            String username = usernametext.getText().toString();
            String password = passwordtext.getText().toString();

            if(username.equals("") && password.equals("")){
                Toast.makeText(getApplicationContext(),"Plaese Enter a Value",Toast.LENGTH_SHORT).show();
            }else {
                SharedPreferences sharedPreferences = getSharedPreferences("userdetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernamekey",username);
                editor.putString("passwordkey",password);
                editor.commit();
                usernametext.setText("");
                passwordtext.setText("");
                Toast.makeText(getApplicationContext(),"Save Data Succesfully",Toast.LENGTH_SHORT).show();
            }


        }else if(v.getId()==R.id.loadbuttonID){

            SharedPreferences sharedPreferences = getSharedPreferences("userdetails", Context.MODE_PRIVATE);
            if(sharedPreferences.contains("usernamekey") && sharedPreferences.contains("passwordkey")){
                String usernames = sharedPreferences.getString("usernamekey","Data not found");
                String passwords = sharedPreferences.getString("passwordkey","Data not found");
                textView.setText(usernames+"\n"+passwords);
            }
        }
    }
}

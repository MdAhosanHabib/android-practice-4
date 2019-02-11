package com.example.ahosanhabib.logindatabaseapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameED, passwordED;
    private Button signinbutton, signupbutton;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameED = findViewById(R.id.signinUsernameEditTextID);
        passwordED = findViewById(R.id.signinpasswordEditTextID);
        signinbutton = findViewById(R.id.signinbuttonID);
        signupbutton = findViewById(R.id.signupherebuttonID);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signinbutton.setOnClickListener(this);
        signupbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String useranme = usernameED.getText().toString();
        String password = passwordED.getText().toString();

        if(v.getId()==R.id.signinbuttonID){

            boolean result = databaseHelper.findPassword(useranme,password);
            if(result==true){
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"Useranme and Password are invalid",Toast.LENGTH_SHORT).show();
            }

        }else if(v.getId()==R.id.signupherebuttonID){
            Intent intent = new Intent(MainActivity.this,signUp.class);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder  alertDialogBuilder;
        alertDialogBuilder = new  AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setTitle("Warning!");
        alertDialogBuilder.setMessage("Do you want to exit?");
        alertDialogBuilder.setCancelable(true);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

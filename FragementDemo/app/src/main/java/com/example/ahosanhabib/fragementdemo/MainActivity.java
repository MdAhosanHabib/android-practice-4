package com.example.ahosanhabib.fragementdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] name  = {"Rakib","Sakib","Sourov","Sumon","Faruk","Mizan","Mamun","Rokon"};

        listView = findViewById(R.id.listviewID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Fragment fragment;

        if(position == 0){
            fragment = new Rakibfragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentID,fragment);
            fragmentTransaction.commit();
        }
        else if(position == 1){

            fragment = new sakibfragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();
        }
        else if(position == 2){

            fragment = new sourovfragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();
        }
        else if(position == 3){

            fragment = new sumonfragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();
        }
        else if(position == 4){

            fragment = new farukfragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();
        }
        else if(position == 5){

            fragment = new mizanfragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();
        }
        else if(position == 6){

            fragment = new mamunfragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();
        }
        else if(position == 7){

            fragment = new rokonfragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder  alertDialogBuilder;
        alertDialogBuilder = new  AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setTitle(R.string.title_text);
        alertDialogBuilder.setMessage(R.string.messege_text);
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

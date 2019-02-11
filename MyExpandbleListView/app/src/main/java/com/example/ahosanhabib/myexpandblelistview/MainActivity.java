package com.example.ahosanhabib.myexpandblelistview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    private CustomAdapter customAdapter;
    private int lastexpandblepossition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = findViewById(R.id.expandblelistviewID);
        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                String groupname = listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupname,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childtext = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),childtext,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastexpandblepossition != -1 && lastexpandblepossition != groupPosition){

                    expandableListView.collapseGroup(lastexpandblepossition);
                }
                lastexpandblepossition = groupPosition;
            }
        });

    }
    public void prepareListData(){
        String[] headerstring = getResources().getStringArray(R.array.list_header);
        String[] childstring = getResources().getStringArray(R.array.list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for(int i=0;i<headerstring.length;i++){

            listDataHeader.add(headerstring[i]);

            List<String> child = new ArrayList<>();
            child.add(childstring[i]);

            listDataChild.put(listDataHeader.get(i),child);

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

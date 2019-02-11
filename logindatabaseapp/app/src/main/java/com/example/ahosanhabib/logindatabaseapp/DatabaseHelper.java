package com.example.ahosanhabib.logindatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.annotation.PluralsRes;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String USER_DETAILS = "UserDetails.db";
    private static final String TABLE_NAME = "User_Details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USER_NAME = "Username";
    private static final String PASSWORD = "Password";
    private static final int Version_number = 1;
    private Context context;

    private static final String Create_table = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255) NOT NULL,"+EMAIL+" TEXT NOT NULL,"+USER_NAME+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISST "+TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, USER_DETAILS, null, Version_number);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(Create_table);
            Toast.makeText(context,"OnCreate is Open",Toast.LENGTH_LONG).show();
        }catch (Exception e)
        {
            Toast.makeText(context,"Execption: "+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"OnUpgreate is Open",Toast.LENGTH_LONG).show();
            db.execSQL(Create_table);
            onCreate(db);
        }catch (Exception e)
        {
            Toast.makeText(context,"Execption: "+e,Toast.LENGTH_LONG).show();
        }
    }

    public long insertData(UserDetails userDetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,userDetails.getName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(USER_NAME,userDetails.getUsername());
        contentValues.put(PASSWORD,userDetails.getPassword());

        long rowiD = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowiD;
    }
    public Boolean findPassword(String uname, String pass){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        Boolean result = false;

        if(cursor.getCount()==0){
            Toast.makeText(context,"No Data Found",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                String username = cursor.getString(3);
                String password = cursor.getString(4);

                if(username.equals(uname) && password.equals(pass)){
                    result = true;
                    break;
                }
            }
        }
        return result;

    }

}

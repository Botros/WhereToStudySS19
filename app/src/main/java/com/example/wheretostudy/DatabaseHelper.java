package com.example.wheretostudy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String USER_TABLE_NAME = "user_table";
    private static final String COUNTRY_TABLE_NAME = "country_table";
    private static final String HASCLIMATE_TABLE_NAME = "hasclimate_table";
    private static final String HASNATURE_TABLE_NAME = "hasnature_table";
    private static final String HASUNIVERSITY_TABLE_NAME = "hasuniversity_table";
    private static final String HASANSWER_TABLE_NAME = "hasanswer_table";
    private static final String CLIMATE_TABLE_NAME = "climate_table";
    private static final String NATURE_TABLE_NAME = "nature_table";
    private static final String UNIVERSITY_TABLE_NAME = "university_table";
    private static final String QUESTION_TABLE_NAME = "question_table";
        private static final String COL1 = "user";
    private static final String COL2 = "password";


    public DatabaseHelper(Context context) {
        super(context, USER_TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);

    }

    private void createTables(SQLiteDatabase db) {
        //Usertable

        String createUserTable = "CREATE TABLE " + USER_TABLE_NAME + " (user TEXT PRIMARY KEY, " + COL2 + " TEXT)";
        db.execSQL(createUserTable);
        String createCountryTable = "CREATE TABLE " + COUNTRY_TABLE_NAME + " (user TEXT PRIMARY KEY, " + COL2 + " TEXT)";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        onCreate(db);
    }

    //neuer User wird hinzugefügt
    public boolean addUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, user);
        contentValues.put(COL2, password);
        Log.d(TAG, "addUser: Adding " + user + " with password "+ password + " to " + USER_TABLE_NAME);
        long result = db.insert(USER_TABLE_NAME, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    //userdaten abfragen
     public boolean checkUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + USER_TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        while(data.moveToNext()){
            //get value from database in column user
            if(data.getString(0) == user){
                if(data.getString(1) == password)
                    return true;
            }
        }
        //wrong data was entered
        return false;
     }



}

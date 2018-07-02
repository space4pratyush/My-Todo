package com.example.pratyush.mytodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
    Context c;

    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //code for opening database
    public DBAdapter openDB(){
        try{
            db=helper.getWritableDatabase();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this;
    }
    //code for closing database
    public void closeDB(){
        try{
            helper.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //code for inserting data into table
    public long add(String title, String description){
        try{
            ContentValues cv=new ContentValues();
            cv.put(Constants.TITLE, title);
            cv.put(Constants.DESCRIPTION, description);
            return db.insert(Constants.TABLE_NAME,Constants.ROW_ID, cv);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    //Retrieving values from table with orderby id in DESC manner.
    public Cursor getAllTask(){
        String[] columns={Constants.ROW_ID,Constants.TITLE,Constants.DESCRIPTION};
        String ord=Constants.ROW_ID+" DESC";
        return db.query(Constants.TABLE_NAME,columns,null,null,null,null,ord);
    }
}

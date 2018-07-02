package com.example.pratyush.mytodo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, Constants.DABASE_NAME, null,Constants.VERSION);
    }
//Table in Database will be created
    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(Constants.CREATE_TB);

        }
        catch (Exception ex){

        }
    }
//Table in Database will be upgraded

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLE_NAME);
        onCreate(db);
    }
}

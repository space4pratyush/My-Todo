package com.example.pratyush.mytodo;

public class Constants {

    //Column should be in database as
    static final String ROW_ID="id";
    static final String TITLE="title";
    static final String DESCRIPTION="description";

    //DATABASE PROPERTIES WILL BE AS BELOW
    static final String DABASE_NAME="db_task";
    static final String TABLE_NAME="table_task";
    static final int VERSION=1;
    static final String CREATE_TB="CREATE TABLE table_task(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "title TEXT NOT NULL,description TEXT NOT NULL);";
}

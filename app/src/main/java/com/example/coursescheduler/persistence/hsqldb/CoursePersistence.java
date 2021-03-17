package com.example.coursescheduler.persistence.hsqldb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.coursescheduler.persistence.IDatabase;

import java.util.List;

public class CoursePersistence extends SQLiteOpenHelper implements IDatabase {

    public static final String DATABASE_NAME = "schedulerDatabase.db";
    public static final String COURSE_TABLE = "course_table";
    public static final String COLUMN_ID = "COURSE ID";
    public static final String COLUMN_NAME = "COURSE NAME";

    public CoursePersistence(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void insert(Object addObject) {

    }

    @Override
    public boolean delete(Object deleteObject) {
        return false;
    }

    @Override
    public boolean update(Object updateObject) {
        return false;
    }

    @Override
    public List getSequential() {
        return null;
    }

    @Override
    public Object fetch(Object fetchObject) {
        return null;
    }
}



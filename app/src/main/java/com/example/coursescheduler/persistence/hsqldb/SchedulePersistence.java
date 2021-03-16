package com.example.coursescheduler.persistence.hsqldb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IDatabase;

import java.util.ArrayList;
import java.util.List;

public class SchedulePersistence extends SQLiteOpenHelper implements IDatabase {

    public static final String DATABASE_NAME = "schedulerDatabase.db";
    public static final String SCHEDULE_TABLE = "schedule_table";
    public static final String COLUMN_ID = "STUDENT ID";
    public static final String COLUMN_CID = "COURSE ID";
    public static final String COLUMN_CNAME = "COURSE NAME";

    public SchedulePersistence(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        String schedule_table = "CREATE TABLE " + SCHEDULE_TABLE + "(" + COLUMN_ID + " INTEGER, " + COLUMN_CID + " INTEGER, " +
        COLUMN_CNAME + " TEXT, PRIMARY KEY (" + COLUMN_ID + "," + COLUMN_CID + ") ," + " FOREIGN KEY " + "(" + COLUMN_ID + ") "
                + "REFERENCES student_table(" +  ;
        db.execSQL(schedule_table);
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SCHEDULE_TABLE);
        onCreate(db);
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

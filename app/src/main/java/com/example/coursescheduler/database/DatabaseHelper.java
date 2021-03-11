package com.example.coursescheduler.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    //create Student database
    public static final String DATABASE_NAME = "newDatabase.db";
    public static final String STUDENT_TABLE = "student_table";
    public static final String COURSE_TABLE = "course_table";
    public static final String SCHEDULE_TABLE = "schedule_table";

    //columns for student table
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";

    //columns for Course Table
    public static final String COL_1C = "ID";
    public static final String COL_2C = "NAME";
    public static final String COL_3C = "TIME";
    public static final String COL_4C = "DAY";

    //columns for schedule table
    public static final String COL_1T = "STUDENT NAME";
    public static final String COL_2T = "COURSE NAME";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create tables
        String student_table = "CREATE TABLE " + STUDENT_TABLE + "(ID INTEGER PRIMARY KEY, NAME TEXT)";
        String course_table = "CREATE TABLE " + COURSE_TABLE + "(ID INTEGER PRIMARY KEY, NAME TEXT, TIME TEXT, DAY TEXT)";
        String schedule_table = "CREATE TABLE " + SCHEDULE_TABLE + "(NAME TEXT, COURSE TEXT)";

        db.execSQL(student_table);
        db.execSQL(course_table);
        db.execSQL(schedule_table);

      // db.execSQL("create table " + STUDENT_TABLE + " (ID INTEGER PRIMARY KEY, " + "NAME TEXT) "); //creates table and elements in table and sets primary key
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SCHEDULE_TABLE);

        onCreate(db);
    }

    public boolean insertStudentData(String ID, String name){
        SQLiteDatabase db = this.getWritableDatabase(); //creates database and table
        ContentValues studentContentValues = new ContentValues();

        //adding columns to student table
        studentContentValues.put(COL_1,ID);
        studentContentValues.put(COL_2, name);


        long result = db.insert(STUDENT_TABLE,null,studentContentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean insertCourseData(String ID, String name, String time, String day){
        SQLiteDatabase db = this.getWritableDatabase(); //creates database and table
        ContentValues courseContentValues = new ContentValues();

        //adding columns to course table
        courseContentValues.put(COL_1C,ID);
        courseContentValues.put(COL_2C, name);
        courseContentValues.put(COL_3C, time);
        courseContentValues.put(COL_4C, day);


        long result = db.insert(COURSE_TABLE,null,courseContentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean insertScheduleData(String name, String course){
        SQLiteDatabase db = this.getWritableDatabase(); //creates database and table
        ContentValues scheduleContentValues = new ContentValues();

        //adding columns to student table
        scheduleContentValues.put(COL_1T,name);
        scheduleContentValues.put(COL_2T, course);


        long result = db.insert(SCHEDULE_TABLE,null,scheduleContentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getStudentData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from student", null);
        return cursor;
    }
}

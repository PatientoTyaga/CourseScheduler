package com.example.coursescheduler.persistence.hsqldb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IDatabase;

public class StudentPersistence extends SQLiteOpenHelper implements IDatabase<Student>{

    public static final String DATABASE_NAME = "schedulerDatabase.db";
    public static final String STUDENT_TABLE = "student_table";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";

    public StudentPersistence(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create tables
        String student_table = "CREATE TABLE " + STUDENT_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, "
        + COLUMN_NAME + " TEXT )";


        db.execSQL(student_table);

        // db.execSQL("create table " + STUDENT_TABLE + " (ID INTEGER PRIMARY KEY, " + "NAME TEXT) "); //creates table and elements in table and sets primary key
    }

    /*
    @Override

    public boolean insert(String value, String j) {
        return false;
    }

     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }

    @Override
    public void addHandler(Student student) {
        //add a new student to student database

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,student.getStudentID());
        values.put(COLUMN_NAME,student.getStudentName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(STUDENT_TABLE,null,values);
        db.close();
    }


    @Override
    public String loadHandler() {
        //get list of students in database to be shown

        String result = "";
        String query = "Select * FROM " + STUDENT_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            int studentId = cursor.getInt(0);
            String studentName = cursor.getString(1);
            result += String.valueOf(studentId) + " " + studentName;
            System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public Student findHandler(String studentname){
        //find student by name

        String query = "Select * From " + STUDENT_TABLE + " WHERE " + COLUMN_NAME + " = " + " ' " +
                studentname + " ' ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Student student = new Student();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            student.setStudentID(Integer.parseInt(cursor.getString(0)));
            student.setStudentName(cursor.getString(1));
            cursor.close();
        }else{
            student = null;
        }
        return  student;
    }

    @Override
    public boolean deleteHandler(int ID) {
        //delete student by id

        boolean result = false;
        String query = "Select * From " + STUDENT_TABLE + " WHERE " + COLUMN_ID + " = ' " + String.valueOf(ID)
                + " ' ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student();
        if(cursor.moveToFirst()){
            student.setStudentID(Integer.parseInt(cursor.getString(0)));
            db.delete(STUDENT_TABLE, COLUMN_ID + "=?",
            new String[]{
                    String.valueOf(student.getStudentID())
            });
            cursor.close();
            result = true;
        }

        db.close();
        return result;
    }

    @Override
    public boolean updateHandler(int ID, String name) {
        //update student

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID,ID);
        args.put(COLUMN_NAME,name);
        return db.update(STUDENT_TABLE,args, COLUMN_ID + "=" + ID, null) > 0;
    }

    /*
    @Override
    public boolean insert(String ID){
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

     */
}
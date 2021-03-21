package com.example.coursescheduler.persistence.sqlite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentPersistence extends SQLiteOpenHelper implements IDatabase<Student>{

    public static final String DATABASE_NAME = "schedulerDatabase.db";
    public static final String STUDENT_TABLE = "student_table";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";

    public static final String SCHEDULE_TABLE = "schedule_table";
    public static final String COLUMN_SID = "STUDENT_ID";
    public static final String COLUMN_CID = "COURSE_ID";

    public static final String COURSE_TABLE = "course_table";
    public static final String COLUMN_TIME = "TIME";
    public static final String COLUMN_DAY = "DAY";


    public StudentPersistence(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create tables
        String student_table = "CREATE TABLE IF NOT EXISTS " + STUDENT_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT )";
        String schedule_table = "CREATE TABLE IF NOT EXISTS " + SCHEDULE_TABLE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SID + " INTEGER, "
                + COLUMN_CID + " INTEGER )";

        String course_table = "CREATE TABLE IF NOT EXISTS " + COURSE_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, "  + COLUMN_TIME + " TEXT, " + COLUMN_DAY + " TEXT)";

        db.execSQL(student_table);
        db.execSQL(schedule_table);
        db.execSQL(course_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SCHEDULE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        onCreate(db);
    }

    @Override
    public void insert(Student student) {
        //add a new student to student database
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,student.getStudentID());
        values.put(COLUMN_NAME,student.getStudentName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(STUDENT_TABLE,null,values);
        db.close();
    }


    @Override
    public List<Student> getSequential() {
        //get list of students in database to be shown
        ArrayList<Student> result = new ArrayList<>();
        String query = "Select * FROM " + STUDENT_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            int studentId = cursor.getInt(0);
            String studentName = cursor.getString(1);
            Student student = new Student(studentId, studentName);
            result.add(student);
//            System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return Collections.unmodifiableList(result);
    }

    @Override
    public Student fetch(Student student){
        //find student by name
        String query = "Select * From " + STUDENT_TABLE + " WHERE " + COLUMN_ID + " = '" + student.getStudentID() + " ' ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Student newStudent = new Student();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            newStudent.setStudentID(Integer.parseInt(cursor.getString(0)));
            newStudent.setStudentName(cursor.getString(1));
            cursor.close();
        }else{
            newStudent = null;
        }
        return  newStudent;
    }

    @Override
    public boolean delete(Student student) {
        //delete student by id
        boolean result = false;
        String query = "Select * From " + STUDENT_TABLE + " WHERE " + COLUMN_ID + " = ' " + student.getStudentID() + " ' ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student newStudent = new Student();
        if(cursor.moveToFirst()){
            newStudent.setStudentID(Integer.parseInt(cursor.getString(0)));
            db.delete(STUDENT_TABLE, COLUMN_ID + "=?",
            new String[]{
                    String.valueOf(newStudent.getStudentID())
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    @Override
    public boolean update(Student student) {
        //update student
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID,student.getStudentID());
        args.put(COLUMN_NAME,student.getStudentName());
        return db.update(STUDENT_TABLE,args, COLUMN_ID + "=" + student.getStudentID(), null) > 0;
    }
}

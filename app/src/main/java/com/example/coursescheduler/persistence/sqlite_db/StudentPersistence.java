package com.example.coursescheduler.persistence.sqlite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.coursescheduler.Message;
import com.example.coursescheduler.Variables;
import com.example.coursescheduler.business.exceptions.StudentNotFoundException;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentPersistence extends SQLiteOpenHelper implements IStudent {

    public StudentPersistence(Context context) {
        super(context, Variables.DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create tables
        String student_table = "CREATE TABLE IF NOT EXISTS " + Variables.STUDENT_TABLE + "(" + Variables.COLUMN_ID + " INTEGER PRIMARY KEY, " + Variables.COLUMN_NAME + " TEXT )";
        String course_table = "CREATE TABLE IF NOT EXISTS " + Variables.COURSE_TABLE + "(" + Variables.COLUMN_COURSEID + " INTEGER PRIMARY KEY, " + Variables.COLUMN_COURSENAME + " TEXT, "  + Variables.COLUMN_TIME + " TEXT, " + Variables.COLUMN_DAY + " TEXT)";

        String schedule_table = "CREATE TABLE IF NOT EXISTS " + Variables.SCHEDULE_TABLE + "("
                + Variables.COLUMN_SID + " INTEGER NOT NULL, "
                + Variables.COLUMN_CID + " INTEGER NOT NULL, PRIMARY KEY( "
                + Variables.COLUMN_SID + ","
                + Variables.COLUMN_CID + ") )";


        db.execSQL(student_table);
        db.execSQL(course_table);
        db.execSQL(schedule_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Variables.STUDENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Variables.SCHEDULE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Variables.COURSE_TABLE);
        onCreate(db);
    }

    @Override
    public void insert(Student student) {
        //add a new student to student database
        SQLiteDatabase db = null;
        try {
            ContentValues values = new ContentValues();
            values.put(Variables.COLUMN_ID,student.getStudentID());
            values.put(Variables.COLUMN_NAME,student.getStudentName());
            db = this.getWritableDatabase();
            db.insert(Variables.STUDENT_TABLE,null,values);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
    }



    @Override
    public List<Student> getSequential() {
        //get list of students in database to be shown
        ArrayList<Student> result = new ArrayList<>();
        String query = "Select * FROM " + Variables.STUDENT_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            int studentId = cursor.getInt(0);
            String studentName = cursor.getString(1);
            Student student = new Student(studentId, studentName);
            result.add(student);
        }
        cursor.close();
        db.close();
        return Collections.unmodifiableList(result);
    }

     

    @Override
    public Student fetch(Student student){
        Student newStudent = new Student();

        try {
            String query = "Select * From " + Variables.STUDENT_TABLE + " WHERE " + Variables.COLUMN_ID + " = '" + student.getStudentID() + " ' ";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query,null);
            if(cursor.moveToFirst()){
                cursor.moveToFirst();
                newStudent.setStudentID(Integer.parseInt(cursor.getString(0)));
                newStudent.setStudentName(cursor.getString(1));
                cursor.close();
            }else{
                throw new StudentNotFoundException();
            }
        }catch(StudentNotFoundException e){
        }
        return  newStudent;
    }

    @Override
    public boolean delete(Student student) {
        //delete student by id

        Student newStudent = new Student();
        boolean result = false;
        SQLiteDatabase db = null;

        try {
            result = false;
            String query = "Select * From " + Variables.STUDENT_TABLE + " WHERE " + Variables.COLUMN_ID + " = ' " + student.getStudentID() + " ' ";
            db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()){
                newStudent.setStudentID(Integer.parseInt(cursor.getString(0)));

                db.delete(Variables.SCHEDULE_TABLE, Variables.COLUMN_SID + "=?",
                new String[]{
                        String.valueOf(newStudent.getStudentID())
                });

                db.delete(Variables.STUDENT_TABLE, Variables.COLUMN_ID + "=?",
                        new String[]{
                                String.valueOf(newStudent.getStudentID())
                        });

                cursor.close();
                result = true;
            }else{
                throw new StudentNotFoundException(Message.student_Not_Found);
            }
        } catch (StudentNotFoundException e) {
        }
        db.close();
        return result;
    }

    @Override
    public boolean update(Student student) {
        //update student
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(Variables.COLUMN_ID,student.getStudentID());
        args.put(Variables.COLUMN_NAME,student.getStudentName());
        return db.update(Variables.STUDENT_TABLE,args, Variables.COLUMN_ID + "=" + student.getStudentID(), null) > 0;
    }
}

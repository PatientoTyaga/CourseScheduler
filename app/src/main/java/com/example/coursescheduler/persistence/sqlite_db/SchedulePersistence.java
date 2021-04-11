package com.example.coursescheduler.persistence.sqlite_db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.coursescheduler.Variables;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.ISchedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchedulePersistence extends SQLiteOpenHelper implements ISchedule{

    public SchedulePersistence(Context context) {
        super(context, Variables.DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String schedule_table = "CREATE TABLE IF NOT EXISTS " + Variables.SCHEDULE_TABLE + "("
                + Variables.COLUMN_SID + " INTEGER NOT NULL, "
                + Variables.COLUMN_CID + " INTEGER NOT NULL, PRIMARY KEY( "
                + Variables.COLUMN_SID + ","
                + Variables.COLUMN_CID + ") )";

        db.execSQL(schedule_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Variables.SCHEDULE_TABLE);
        onCreate(db);
    }

    @Override
    public List<Schedule> getSequential(Student student) {
        ArrayList<Schedule> result = new ArrayList<>();
        try {
            String query = "Select * FROM " + Variables.SCHEDULE_TABLE + " WHERE " + Variables.COLUMN_SID + " = '" + student.getStudentID() + " ' ";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                int studentId = cursor.getInt(0);
                int courseId = cursor.getInt(1);
                Schedule schedule = new Schedule(studentId, courseId);
                result.add(schedule);
            }
            cursor.close();
            db.close();
            return Collections.unmodifiableList(result);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getCourseIDs(Student student) {
        ArrayList<Integer> result = new ArrayList<>();
        try {
            String query = "Select * FROM " + Variables.SCHEDULE_TABLE + " WHERE " + Variables.COLUMN_SID + " = '" + student.getStudentID() + " ' ";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                int courseId = cursor.getInt(1);
                result.add(courseId);
            }
            cursor.close();
            db.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void insert(Schedule schedule) {
        Log.i(Variables.tag, "got to insert schedule");
        Log.i(Variables.tag, Variables.student_Name +schedule.getStudentID() + ", " + Variables.course_ID + ": " + schedule.getCourseID());
        ContentValues values = new ContentValues();
        values.put(Variables.COLUMN_SID,schedule.getStudentID());
        values.put(Variables.COLUMN_CID,schedule.getCourseID());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Variables.SCHEDULE_TABLE,null,values);
        db.close();
    }

    @Override
    public boolean deleteSchedule(Student student) {
        //this method will deleteSchedule

        boolean result = false;
        String query = "Select * From " + Variables.SCHEDULE_TABLE + " WHERE " + Variables.COLUMN_SID + " = ' " + student.getStudentID() + " ' ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Schedule newSchedule = new Schedule();
        if(cursor.moveToFirst()){
            newSchedule.setStudent(Integer.parseInt(cursor.getString(0)));
            db.delete(Variables.SCHEDULE_TABLE, Variables.COLUMN_SID + "=?",
                    new String[]{
                            String.valueOf(newSchedule.getStudentID())
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    @Override
    public boolean delete(Schedule schedule) {
        //this method will delete course from schedule

        boolean result = false;
        Log.i(Variables.tag, "course to be deleted : " + schedule.getCourseID());
        String query = "Select * From " + Variables.SCHEDULE_TABLE + " WHERE " + Variables.COLUMN_SID + " = ' " + schedule.getStudentID() + " ' ";
        Log.i(Variables.tag, "query: "+ query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Schedule newSchedule = new Schedule();
        if(cursor.moveToFirst()){
            Log.i(Variables.tag, "course : " + cursor.getString(1));
            db.delete(Variables.SCHEDULE_TABLE, Variables.COLUMN_CID + "=?",
                    new String[]{
                            String.valueOf(schedule.getCourseID())
                    });
            cursor.close();
            result = true;
            Log.i(Variables.tag, "course deleted from schedule");
        }
        db.close();
        return result;
    }

}

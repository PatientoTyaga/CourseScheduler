package com.example.coursescheduler.persistence.sqlite_db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.ISchedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchedulePersistence extends SQLiteOpenHelper implements ISchedule{

    public static final String DATABASE_NAME = "schedulerDatabase.db";
    public static final String SCHEDULE_TABLE = "schedule_table";
    public static final String COLUMN_SID = "STUDENT_ID";
    public static final String COLUMN_CID = "COURSE_ID";
    public static final String COLUMN_ID = "SCHEDULE_ID";

    public SchedulePersistence(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String schedule_table = "CREATE TABLE IF NOT EXISTS " + SCHEDULE_TABLE + "("
                + COLUMN_ID + "AUTOINCREMENT PRIMARY KEY, "
                + COLUMN_SID + " INTEGER, "
                + COLUMN_CID + " INTEGER )";
        db.execSQL(schedule_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SCHEDULE_TABLE);
        onCreate(db);
    }

    @Override
    public List<Schedule> getSequential(Student student) {
        ArrayList<Schedule> result = new ArrayList<>();
        try {
            String query = "Select * FROM " + SCHEDULE_TABLE + " WHERE " + COLUMN_SID + " = '" + student.getStudentID() + " ' ";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
               // String scheduleName = cursor.getString(0);
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

    @Override
    public void insert(Schedule schedule) {
        Log.i("myTag", "got to insert schedule");
        Log.i("myTag", "studentID in schedule: "+schedule.getStudentID() + ", courseID: "+schedule.getCourseID());
        ContentValues values = new ContentValues();
        values.put(COLUMN_SID,schedule.getStudentID());
        values.put(COLUMN_CID,schedule.getCourseID());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(SCHEDULE_TABLE,null,values);
        db.close();
    }

    @Override
    public boolean deleteSchedule(Student student) {
        boolean result = false;
        String query = "Select * From " + SCHEDULE_TABLE + " WHERE " + COLUMN_SID + " = ' " + student.getStudentID() + " ' ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Schedule newSchedule = new Schedule();
        if(cursor.moveToFirst()){
            newSchedule.setStudent(Integer.parseInt(cursor.getString(0)));
            db.delete(SCHEDULE_TABLE, COLUMN_SID + "=?",
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
    public boolean deleteCourse(Schedule schedule) {
        boolean result = false;
        Log.i("myTag", "course to be deleted : " + schedule.getCourseID());
        String query = "Select * From " + SCHEDULE_TABLE + " WHERE " + COLUMN_SID + " = ' " + schedule.getStudentID() + " ' ";
        Log.i("myTag", "query: "+ query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Schedule newSchedule = new Schedule();
        if(cursor.moveToFirst()){
            Log.i("myTag", "course : " + cursor.getString(1));
            db.delete(SCHEDULE_TABLE, COLUMN_CID + "=?",
                    new String[]{
                            String.valueOf(schedule.getCourseID())
                    });
            cursor.close();
            result = true;
            Log.i("myTag", "course deleted from schedule");
        }
        db.close();
        return result;
    }

    @Override
    public boolean update(Schedule updateObject) {
        return false;
    }

    @Override
    public Schedule fetch(Schedule fetchObject) {
        return null;
    }

}

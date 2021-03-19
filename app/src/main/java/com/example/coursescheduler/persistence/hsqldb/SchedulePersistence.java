package com.example.coursescheduler.persistence.hsqldb;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.ISchedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchedulePersistence extends SQLiteOpenHelper implements ISchedule{

    public static final String DATABASE_NAME = "schedulerDatabase.db";
    public static final String SCHEDULE_TABLE = "schedule_table";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_SID = "STUDENT_ID";
    public static final String COLUMN_CID = "COURSE_ID";

    public SchedulePersistence(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String schedule_table = "CREATE TABLE IF NOT EXISTS " + SCHEDULE_TABLE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SID + " INTEGER, "
                + COLUMN_CID + " TEXT )";
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
                String scheduleName = cursor.getString(1);
                int studentId = cursor.getInt(2);
                String courseId = cursor.getString(3);
                Schedule schedule = new Schedule(scheduleName, studentId, courseId);
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
        ContentValues values = new ContentValues();
        values.put(COLUMN_SID,schedule.getStudentID());
        values.put(COLUMN_CID,schedule.getCourseName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(SCHEDULE_TABLE,null,values);
        db.close();
    }

    @Override
    public boolean delete(Schedule deleteObject) {
        return false;
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

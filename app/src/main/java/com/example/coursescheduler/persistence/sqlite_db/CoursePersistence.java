package com.example.coursescheduler.persistence.sqlite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.coursescheduler.Variables;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.persistence.ICourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoursePersistence extends SQLiteOpenHelper implements ICourse {

    public CoursePersistence(Context context) {
        super(context, Variables.DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String course_table = "CREATE TABLE IF NOT EXISTS " + Variables.COURSE_TABLE + "(" + Variables.COLUMN_ID + " INTEGER PRIMARY KEY, " + Variables.COLUMN_NAME + " TEXT, "  + Variables.COLUMN_TIME + " TEXT, " + Variables.COLUMN_DAY + " TEXT)";
        db.execSQL(course_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Variables.COURSE_TABLE);
        onCreate(db);
    }

    @Override
    public void insert(Course course) {
        //add a new course to course database
        Log.i(Variables.tag, Variables.id + ": "+course.getCourseId()+", " + Variables.name + ": "+course.getCourseName()+", " + Variables.time + ": "+course.getCourseTime()+", " + Variables.day + ": "+course.getCourseDay());
        ContentValues values = new ContentValues();
        values.put(Variables.COLUMN_ID,course.getCourseId());
        values.put(Variables.COLUMN_NAME,course.getCourseName());
        values.put(Variables.COLUMN_TIME,course.getCourseTime());
        values.put(Variables.COLUMN_DAY,course.getCourseDay());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Variables.COURSE_TABLE,null,values);
        db.close();
    }

    @Override
    public boolean delete(Course course) {
        //delete course by id

        boolean result = false;
        Log.i(Variables.tag, "course to be deleted : " + course.getCourseId());
        String query = "Select * From " + Variables.SCHEDULE_TABLE + " WHERE " + Variables.COLUMN_CID + " = ' " + course.getCourseId() + " ' ";
        Log.i(Variables.tag, "query: "+ query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Course newCourse = new Course();
        if(cursor.moveToFirst()){
            newCourse.setCourseId(cursor.getInt(0));
            Log.i(Variables.tag, "course : " + cursor.getString(0));
            db.delete(Variables.SCHEDULE_TABLE, Variables.COLUMN_ID + "=?",
                    new String[]{
                            String.valueOf(newCourse.getCourseId())
                    });
            cursor.close();
            result = true;
            Log.i(Variables.tag, "course deleted from schedule");
        }
        db.close();
        return result;
    }

    @Override
    public List<Course> getSequential() {
        //get list of courses in database to be shown
        ArrayList<Course> result = new ArrayList<>();
        String query = "Select * FROM " + Variables.COURSE_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            int courseId = cursor.getInt(0);
            String courseName = cursor.getString(1);
            String courseTime = cursor.getString(2);
            String courseDay = cursor.getString(3);
            Course course = new Course(courseId, courseName, courseTime, courseDay);
            result.add(course);
        }
        cursor.close();
        db.close();
        return Collections.unmodifiableList(result);
    }


    public ArrayList<Course> getCourses(ArrayList<Integer> courseIds) {
        //find course by id
        ArrayList<Course> courses = new ArrayList<>();

        Course newCourse = new Course();
        int count = 0;

        while(courseIds.size() > count){
            String query = "Select * From " + Variables.COURSE_TABLE + " WHERE " + Variables.COLUMN_ID + " = '" + courseIds.get(count) + " ' ";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query,null);
            if(cursor.moveToFirst()){
                cursor.moveToFirst();
                newCourse.setCourseId(cursor.getInt(0));
                newCourse.setCourseName(cursor.getString(1));
                newCourse.setCourseTime(cursor.getString(2));
                newCourse.setCourseDay(cursor.getString(3));
                courses.add(newCourse);
                cursor.close();
            }else{
                newCourse = null;
            }
            count++;
        }

        return  courses;
    }

}



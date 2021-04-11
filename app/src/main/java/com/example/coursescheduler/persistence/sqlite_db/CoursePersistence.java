package com.example.coursescheduler.persistence.sqlite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.persistence.ICourse;
import com.example.coursescheduler.persistence.IDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CoursePersistence extends SQLiteOpenHelper implements ICourse {

    public static final String DATABASE_NAME = "schedulerDatabase.db";
    public static final String COURSE_TABLE = "course_table";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_TIME = "TIME";
    public static final String COLUMN_DAY = "DAY";

    public static final String SCHEDULE_TABLE = "schedule_table";
    public static final String COLUMN_SID = "STUDENT_ID";
    public static final String COLUMN_CID = "COURSE_ID";

    public CoursePersistence(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String course_table = "CREATE TABLE IF NOT EXISTS " + COURSE_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, "  + COLUMN_TIME + " TEXT, " + COLUMN_DAY + " TEXT)";
        db.execSQL(course_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        onCreate(db);
    }

    @Override
    public void insert(Course course) {
        //add a new course to course database
        Log.i("myTag", "id: "+course.getCourseId()+", name: "+course.getCourseName()+", time: "+course.getCourseTime()+", day: "+course.getCourseDay());
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,course.getCourseId());
        values.put(COLUMN_NAME,course.getCourseName());
        values.put(COLUMN_TIME,course.getCourseTime());
        values.put(COLUMN_DAY,course.getCourseDay());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(COURSE_TABLE,null,values);
        db.close();
    }

    @Override
    public boolean delete(Course course) {
        //delete course by id

        boolean result = false;
        Log.i("myTag", "course to be deleted : " + course.getCourseId());
        String query = "Select * From " + SCHEDULE_TABLE + " WHERE " + COLUMN_CID + " = ' " + course.getCourseId() + " ' ";
        Log.i("myTag", "query: "+ query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Course newCourse = new Course();
        if(cursor.moveToFirst()){
            newCourse.setCourseId(cursor.getInt(0));
            Log.i("myTag", "course : " + cursor.getString(0));
            db.delete(SCHEDULE_TABLE, COLUMN_ID + "=?",
                    new String[]{
                            String.valueOf(newCourse.getCourseId())
                    });
            cursor.close();
            result = true;
            Log.i("myTag", "course deleted from schedule");
        }
        db.close();
        return result;
    }

    /*
    @Override
    public boolean update(Course course) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID,course.getCourseId());
        args.put(COLUMN_NAME,course.getCourseName());
        args.put(COLUMN_TIME,course.getCourseTime());
        args.put(COLUMN_DAY,course.getCourseDay());
        return db.update(COURSE_TABLE,args, COLUMN_ID + "=" + course.getCourseId(), null) > 0;
    }

     */

    @Override
    public List<Course> getSequential() {
        //get list of courses in database to be shown
        ArrayList<Course> result = new ArrayList<>();
        String query = "Select * FROM " + COURSE_TABLE;
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
            String query = "Select * From " + COURSE_TABLE + " WHERE " + COLUMN_ID + " = '" + courseIds.get(count) + " ' ";

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



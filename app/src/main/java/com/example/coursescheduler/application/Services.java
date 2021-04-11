package com.example.coursescheduler.application;

import android.content.Context;

import com.example.coursescheduler.persistence.ICourse;
import com.example.coursescheduler.persistence.ISchedule;
import com.example.coursescheduler.persistence.IStudent;
import com.example.coursescheduler.persistence.sqlite_db.CoursePersistence;
import com.example.coursescheduler.persistence.sqlite_db.SchedulePersistence;
import com.example.coursescheduler.persistence.sqlite_db.StudentPersistence;

public class Services {

    private static IStudent studentPersistence = null;
    private static ICourse coursePersistence = null;
    private static ISchedule schedulePersistence = null;

    public static synchronized IStudent getStudentPersistence(Context context)
    {
        if (studentPersistence == null){
            studentPersistence = new StudentPersistence(context.getApplicationContext());
        }
        return studentPersistence;
    }

    public static synchronized ICourse getCoursePersistence(Context context)
    {
        if (coursePersistence == null){
            coursePersistence = new CoursePersistence(context.getApplicationContext());
        }
        return coursePersistence;
    }

    public static synchronized ISchedule getSchedulePersistence(Context context)
    {
        if (schedulePersistence == null){
            schedulePersistence = new SchedulePersistence(context.getApplicationContext());
        }
        return schedulePersistence;
    }

}

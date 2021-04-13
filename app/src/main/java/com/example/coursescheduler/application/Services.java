package com.example.coursescheduler.application;

import android.content.Context;

import com.example.coursescheduler.persistence.IDatabase;
import com.example.coursescheduler.persistence.ISchedule;
import com.example.coursescheduler.persistence.hsqldb.CoursePersistence;
import com.example.coursescheduler.persistence.hsqldb.SchedulePersistence;
import com.example.coursescheduler.persistence.hsqldb.StudentPersistence;

public class Services {

    private static IDatabase studentPersistence = null;
    private static IDatabase coursePersistence = null;
    private static ISchedule schedulePersistence = null;

    public static synchronized IDatabase getStudentPersistence(Context context)
    {
        if (studentPersistence == null){
            studentPersistence = new StudentPersistence(context.getApplicationContext());
        }
        return studentPersistence;
    }

    public static synchronized IDatabase getCoursePersistence(Context context)
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

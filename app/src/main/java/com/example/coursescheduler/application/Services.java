package com.example.coursescheduler.application;

import android.content.Context;

import com.example.coursescheduler.persistence.IDatabase;
import com.example.coursescheduler.persistence.hsqldb.StudentPersistence;

public class Services {

    private static IDatabase studentPersistence = null;

    public static synchronized IDatabase getStudentPersistence(Context context)
    {
        if (studentPersistence == null)
        {
            studentPersistence = new StudentPersistence(context.getApplicationContext());
        }

        return studentPersistence;
    }



}

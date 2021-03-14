package com.example.coursescheduler.application;

import com.example.coursescheduler.persistence.IDatabase;
import com.example.coursescheduler.persistence.hsqldb.StudentPersistence;

public class Services {

    private static IDatabase studentPersistence = null;

    public static synchronized IDatabase getStudentPersistence()
    {
        if (studentPersistence == null)
        {
            studentPersistence = new StudentPersistence(this);
            studentPersistence = new StudentPersistence(Main.getDBPathName());
        }

        return studentPersistence;
    }



}

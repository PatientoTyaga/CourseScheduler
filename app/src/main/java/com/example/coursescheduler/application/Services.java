package com.example.coursescheduler.application;

import android.database.sqlite.SQLiteDatabase;

import com.example.coursescheduler.database.DatabaseHelper;
import com.example.coursescheduler.persistence.IStudentPersistence;
import com.example.coursescheduler.persistence.hsqldb.StudentPersistenceHSQLDB;

public class Services {

    private static IStudentPersistence studentPersistence = null;


    public static synchronized IStudentPersistence getStudentPersistence()
    {
        if (studentPersistence == null)
        {
            //studentPersistence = new StudentPersistenceStub();
            studentPersistence = new StudentPersistenceHSQLDB(Main.getDBPathName());
        }

        return studentPersistence;
    }



}

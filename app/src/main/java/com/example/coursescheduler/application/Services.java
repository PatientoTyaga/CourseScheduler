package com.example.coursescheduler.application;

import android.database.sqlite.SQLiteDatabase;

import com.example.coursescheduler.database.DatabaseHelper;
import com.example.coursescheduler.persistence.IStudentPersistence;
import com.example.coursescheduler.persistence.hsqldb.StudentPersistenceHSQLDB;

public class Services {

    /*

    private static DatabaseHelper db;
    private static IStudentPersistence istudentPersistence = null;

    public static synchronized IStudentPersistence getStudentPersistence()
    {
        if (istudentPersistence == null)
        {
            //studentPersistence = new StudentPersistenceStub();
            istudentPersistence = new StudentPersistenceHSQLDB(db.getDbPath());
        }

        return istudentPersistence;
    }

     */


}

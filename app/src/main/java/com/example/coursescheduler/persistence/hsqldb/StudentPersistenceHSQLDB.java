package com.example.coursescheduler.persistence.hsqldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.coursescheduler.database.DatabaseHelper;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IStudentPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentPersistenceHSQLDB implements IStudentPersistence {

    DatabaseHelper mydb;
    Cursor cursor;

    @Override
    public List<Student> getStudentSequential() {
        cursor = mydb.getStudentData();
        final List<Student> students = new ArrayList<>();
        Student student;

        while(cursor != null){
            student = new Student(cursor.getString(0), cursor.getString(1));
            students.add(student);
        }

        return students;
    }



}
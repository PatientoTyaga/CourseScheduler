package com.example.coursescheduler.persistence;

import android.content.Context;
import android.database.Observable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.coursescheduler.business.exceptions.StudentNotFoundException;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public interface IDatabase<T>{
    void insert(T addObject); //used to add e.g add student, course, schedule
    boolean delete(T deleteObject); //used to delete by either course,schedule or student
}

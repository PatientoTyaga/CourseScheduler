package com.example.coursescheduler.persistence;

import android.database.Observable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public interface IDatabase<T>{
    void onCreate(SQLiteDatabase db); //used to create database when called
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    void addHandler(T addObject); //used to add e.g add student, course, schedule
    boolean deleteHandler(int ID); //used to delete by id (we can update this later)
    boolean updateHandler(int ID, String name); //used to update by id(we can delete this if it isn't needed)
    public String loadHandler(); //used to get list of what is in database. like list elements in student table
    public T findHandler(String find); //used to find e.g find student by student name
}

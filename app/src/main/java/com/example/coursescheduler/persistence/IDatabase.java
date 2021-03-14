package com.example.coursescheduler.persistence;

import android.database.Observable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public interface IDatabase<T>{
    void onCreate(SQLiteDatabase db); //used to create database when called
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    void insert(T addObject); //used to add e.g add student, course, schedule
    boolean delete(T deleteObject); //used to delete by id (we can update this later)
    boolean update(T updateObject); //used to update by id(we can delete this if it isn't needed)
    List<T> getSequential(); //used to get list of what is in database. like list elements in student table
    T fetch(T fetchObject); //used to find e.g find student by student name
}

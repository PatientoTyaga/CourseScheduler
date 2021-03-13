package com.example.coursescheduler.persistence;

import android.database.Observable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public interface IDatabase<T>{
    void onCreate(SQLiteDatabase db);
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    void addHandler(T addObject);
    boolean deleteHandler(int ID);
    boolean updateHandler(int ID, String name);
    public String loadHandler();
    public T findHandler(String find);
}

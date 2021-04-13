package com.example.coursescheduler.persistence;

public interface IDatabase<T>{
    void insert(T addObject); //used to add e.g add student, course, schedule
    boolean delete(T deleteObject); //used to delete by either course,schedule or student
}

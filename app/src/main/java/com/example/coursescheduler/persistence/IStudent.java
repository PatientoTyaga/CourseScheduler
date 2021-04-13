package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Student;

import java.util.List;

public interface IStudent extends IDatabase<Student>{
    boolean update(Student student); //used to update by id(we can delete this if it isn't needed)
    Student fetch(Student student); //used to find e.g find student by student name
    List<Student> getSequential(); //used to get list of what is in database. like list elements in student table
}

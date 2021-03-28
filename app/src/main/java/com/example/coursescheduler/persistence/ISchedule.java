package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.List;

public interface ISchedule {

    List<Schedule> getSequential(Student object); //used to get list of what is in database. like list elements in student table
    void insert(Schedule addObject); //used to add e.g add student, course, schedule
    boolean deleteSchedule(Student deleteObject); //used to delete by id (we can update this later)
    boolean deleteCourse(Schedule deleteObject); //used to delete by id (we can update this later)
    boolean update(Schedule updateObject); //used to update by id(we can delete this if it isn't needed)
    Schedule fetch(Schedule fetchObject); //used to find e.g find student by student name


}

package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public interface ISchedule extends IDatabase<Schedule>{

    List<Schedule> getSequential(Student object); //used to get list of what is in database. like list elements in student table
    boolean deleteSchedule(Student deleteObject); //used to delete by id (we can update this later)
    ArrayList<Integer> getCourseIDs(Student student);
}

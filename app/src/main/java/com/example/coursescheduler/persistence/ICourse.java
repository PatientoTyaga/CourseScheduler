package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Course;

import java.util.ArrayList;
import java.util.List;

public interface ICourse extends IDatabase<Course>{
    List<Course> getSequential(); //used to get list of what is in database. like list elements in student table
    ArrayList<Course> getCourses(ArrayList<Integer> courseIds); //returns list of courses

}

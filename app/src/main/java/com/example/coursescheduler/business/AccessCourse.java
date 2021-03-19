package com.example.coursescheduler.business;

import android.content.Context;

import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.Database;
import com.example.coursescheduler.persistence.IDatabase;

import java.util.Collections;
import java.util.List;

public class AccessCourse{
    private IDatabase coursePersistence;
    private List<Course> courses;
    private Course course;

    public AccessCourse(Context context){
        this.coursePersistence = Services.getCoursePersistence(context);
        courses = null;
        course = null;
    }

    public List<Course> getCourseSequential(){
        courses = coursePersistence.getSequential();
        return Collections.unmodifiableList(courses);
    }

    public Course fetchStudent(Course course) {
        this.course = (Course) coursePersistence.fetch(course);
        return this.course;
    }

    public void insertCourse(Course course){
        coursePersistence.insert(course);
    }


}

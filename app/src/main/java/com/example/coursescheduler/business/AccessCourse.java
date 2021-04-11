package com.example.coursescheduler.business;

import android.content.Context;
import android.util.Log;

import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.persistence.ICourse;
import com.example.coursescheduler.persistence.IDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessCourse{
    private ICourse coursePersistence;
    private List<Course> courses;
    private Course course;

    public AccessCourse(Context context){
        this.coursePersistence = Services.getCoursePersistence(context);
        courses = null;
        course = null;
    }

    public AccessCourse(final ICourse coursePersistence) {
        this.coursePersistence = coursePersistence;
    }

    public List<Course> getCourseSequential(){
        courses = coursePersistence.getSequential();
        return Collections.unmodifiableList(courses);
    }


    public void insertCourse(Course course){
        coursePersistence.insert(course);
    }

    public void deleteCourse(Course course){
        Log.i("myTag", "deleting course");
        coursePersistence.delete(course);
    }

    public ArrayList<Course> getCourses(ArrayList<Integer> courseIds){
        return coursePersistence.getCourses(courseIds);
    }
}

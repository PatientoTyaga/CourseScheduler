package com.example.coursescheduler.business;

import com.example.coursescheduler.Service.Service;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.persistence.ICoursePersistence;
import com.example.coursescheduler.persistence.Database;
import com.example.coursescheduler.persistence.IStudentPersistence;

import java.util.Collections;
import java.util.List;

public class AccessCourse{
    private ICoursePersistence coursePersistence;
    private List<Course> courses;

    public AccessCourse(){
        this.coursePersistence = Service.getCoursePersistence();
        courses = null;
    }
    public AccessCourse(final ICoursePersistence coursePersistence){
        this();
        this.coursePersistence = coursePersistence;
    }

    public List<Course> getCourseSequential(){
        courses = coursePersistence.getCourseSequential();
        return Collections.unmodifiableList(courses);
    }

    public void setCurrentCourse(Course course) {
        coursePersistence.setCurrentCourse(course);
    }

}

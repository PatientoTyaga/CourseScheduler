package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.persistence.ICoursePersistence;
import com.example.coursescheduler.persistence.Database;

import java.util.Collections;
import java.util.List;

public class AccessCourse implements IAccessCourse{
    private ICoursePersistence coursePersistence;
    private List<Course> courses;
    private Course currentCourse;
    private Schedule currentSchedule;

    public AccessCourse(ICoursePersistence coursePersistence){
        this.coursePersistence = coursePersistence;
        courses = null;
        currentCourse = null;
    }

    @Override
    public List<Course> getCourseSequential(){
        courses = coursePersistence.getCourseSequential();
        return Collections.unmodifiableList(courses);
    }

    @Override
    public void setCurrentCourse(Course course) {
        currentCourse = course;
    }

    @Override
    public Course getCurrentCourse() {
        currentCourse = coursePersistence.getCurrentCourse();
        return currentCourse;
    }

    @Override
    public Schedule getCurrentSchedule() {
        currentSchedule = coursePersistence.getCurrentSchedule();
        return currentSchedule;
    }
}

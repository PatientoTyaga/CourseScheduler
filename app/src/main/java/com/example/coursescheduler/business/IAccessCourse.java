package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;

import java.util.List;

public interface IAccessCourse {
    List<Course> getCourseSequential();
    void setCurrentCourse(Course course);
    Course getCurrentCourse();
    Schedule getCurrentSchedule();
}

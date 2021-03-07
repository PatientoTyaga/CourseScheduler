package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;

import java.util.List;

public interface ICoursePersistence {
    List<Course> getCourseSequential();
    void setCurrentCourse(Course course);
    Course getCurrentCourse();
    Schedule getCurrentSchedule();
}

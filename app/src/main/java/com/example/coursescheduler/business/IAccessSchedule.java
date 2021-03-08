package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.List;

public interface IAccessSchedule {
//    List<Schedule> getScheduleSequential();
    List<Schedule> getScheduleSequential(final Student student);
    void setCurrentSchedule(Schedule schedule);
    Schedule getCurrentSchedule();
    Student getCurrentStudent();
    void addCourse(Course course);
    List<Course> getCourseList(Schedule schedule);
    Course getCurrentCourse();
}

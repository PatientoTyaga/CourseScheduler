package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.List;

public interface IAccessSchedule {
    List<Schedule> getScheduleSequential();
    List<Schedule> getScheduleSequential(Student student);
    void setCurrentSchedule(Schedule schedule);
    Schedule getCurrentSchedule();
    Student getCurrentStudent();
    void addCourse(Course course);
}

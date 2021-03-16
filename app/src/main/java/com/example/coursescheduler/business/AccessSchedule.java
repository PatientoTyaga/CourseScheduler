package com.example.coursescheduler.business;

import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.*;

public class AccessSchedule{

    /*
    private ISchedulePersistence schedulePersistence;
    private List<Schedule> currentStudentScheduleList;
    private Schedule currentSchedule;
    private Student currentStudent;
    private Course currentCourse;
    private List<Course> courseList;

    public AccessSchedule(){
        this.schedulePersistence = Service.getSchedulePersistence();
        currentStudentScheduleList = null;
        currentSchedule = null;
        currentStudent = null;
        currentCourse = null;
        courseList = null;
    }
    public AccessSchedule(final ISchedulePersistence schedulePersistence) {
        this();
        this.schedulePersistence = schedulePersistence;
    }

    public List<Schedule> getScheduleSequential(final Student student) {
        currentStudentScheduleList = schedulePersistence.getScheduleSequential(student);
        return Collections.unmodifiableList(currentStudentScheduleList);
    }

    public void setCurrentSchedule(Schedule schedule) {
        schedulePersistence.setCurrentSchedule(schedule);
    }

    public Schedule getCurrentSchedule() {
        currentSchedule = schedulePersistence.getCurrentSchedule();
        return currentSchedule;
    }

    public Student getCurrentStudent() {
        currentStudent = schedulePersistence.getCurrentStudent();
        return currentStudent;
    }

    public Course getCurrentCourse(){
        currentCourse = schedulePersistence.getCurrentCourse();
        return currentCourse;
    }


     */
}

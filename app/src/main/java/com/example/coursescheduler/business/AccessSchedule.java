package com.example.coursescheduler.business;

import com.example.coursescheduler.Service.Service;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.ISchedulePersistence;

import java.util.*;

public class AccessSchedule implements ISchedulePersistence{
    private ISchedulePersistence schedulePersistence;
//    private List<Schedule> schedules;
    private List<Schedule> currentStudentScheduleList;
    private Schedule currentSchedule;
    private Student currentStudent;
    private Course currentCourse;
    private List<Course> courseList;

    public AccessSchedule(){
        this.schedulePersistence = Service.getSchedulePersistence();;
//        schedules = null;
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

//        @Override
//    public List<Schedule> getScheduleSequential(){
//        schedules = schedulePersistence.getScheduleSequential();
//        return Collections.unmodifiableList(schedules);
//    }

    @Override
    public List<Schedule> getScheduleSequential(final Student student) {
        currentStudentScheduleList = schedulePersistence.getScheduleSequential(student);
        return Collections.unmodifiableList(currentStudentScheduleList);
    }

    @Override
    public void setCurrentSchedule(Schedule schedule) {
        schedulePersistence.setCurrentSchedule(schedule);
    }

    @Override
    public Schedule getCurrentSchedule() {
        currentSchedule = schedulePersistence.getCurrentSchedule();
        return currentSchedule;
    }

    @Override
    public Student getCurrentStudent() {
        currentStudent = schedulePersistence.getCurrentStudent();
        return currentStudent;
    }

    @Override
    public Course getCurrentCourse(){
        currentCourse = schedulePersistence.getCurrentCourse();
        return currentCourse;
    }

    @Override
    public void addCourse(Course course) {
        schedulePersistence.addCourse(course);
    }

    @Override
    public List<Course> getCourseList(Schedule schedule) {
        courseList = schedulePersistence.getCourseList(schedule);
        return courseList;
    }


}

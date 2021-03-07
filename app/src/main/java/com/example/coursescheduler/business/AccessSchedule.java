package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.ISchedulePersistence;

import java.util.*;

public class AccessSchedule implements ISchedulePersistence{
    private ISchedulePersistence schedulePersistence;
    private List<Schedule> schedules;
    private List<Schedule> currentStudentScheduleList;
    private Schedule currentSchedule;
    private Student currentStudent;

    public AccessSchedule(ISchedulePersistence schedulePersistence){
        this.schedulePersistence = schedulePersistence;
        schedules = null;
        currentStudentScheduleList = null;
        currentSchedule = null;
        currentStudent = null;
    }

    @Override
    public List<Schedule> getScheduleSequential(){
        schedules = schedulePersistence.getScheduleSequential();
        return Collections.unmodifiableList(schedules);
    }

    @Override
    public List<Schedule> getScheduleSequential(Student student) {
        currentStudentScheduleList = schedulePersistence.getScheduleSequential(student);
        return currentStudentScheduleList;
    }

    @Override
    public void setCurrentSchedule(Schedule schedule) {
        currentSchedule = schedule;
    }

    @Override
    public Schedule getCurrentSchedule(){
        currentSchedule = schedulePersistence.getCurrentSchedule();
        return currentSchedule;
    }

    @Override
    public Student getCurrentStudent() {
        currentStudent = schedulePersistence.getCurrentStudent();
        return currentStudent;
    }

    @Override
    public void addCourse(Course course) {
        currentSchedule.getCourseList().add(course);
    }

}

package com.example.coursescheduler.business;

import android.content.Context;
import android.util.Log;

import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.ISchedule;

import java.util.*;

public class AccessSchedule{
    private ISchedule schedulePersistence;
    private List<Schedule> scheduleList;
    private Schedule schedule;

    public AccessSchedule(Context context){
        this.schedulePersistence = Services.getSchedulePersistence(context);
        scheduleList = null;
        schedule = null;
        schedule = null;
    }

    public AccessSchedule(final ISchedule schedulePersistence) {
        this.schedulePersistence = schedulePersistence;
    }


    public List<Schedule> getScheduleSequential(final Student student) {
        //Log.i("myTag", "I am here at AccessSchedule");
        scheduleList = schedulePersistence.getSequential(student);
        return Collections.unmodifiableList(scheduleList);
    }

    public void insertSchedule(Schedule schedule){
        schedulePersistence.insert(schedule);
    }

    public void deleteSchedule(Student student){
        schedulePersistence.deleteSchedule(student);
    }

    public void deleteCourse(Schedule schedule){
        schedulePersistence.deleteCourse(schedule);
    }


    public Schedule fetchStudent(Schedule student) {
        return (Schedule) schedulePersistence.fetch(schedule);
    }

    public void updateStudent (Schedule schedule){
        schedulePersistence.update(schedule);
    }

}

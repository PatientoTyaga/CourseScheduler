package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.persistence.SchedulePersistence;

import java.util.*;

public class AccessSchedule {
    private SchedulePersistence schedulePersistence;
    private List<Schedule> schedules;
    private Schedule schedule;
    private int currentStudent;
    private int currentCourse;

    public AccessSchedule(){
        schedules = null;
        schedule = null;
        currentCourse = 0;
        currentStudent = 0;
    }

    public List<Schedule> getScheduleList(){
        schedules = schedulePersistence.getScheduleSequential();
        return schedules;
    }

}

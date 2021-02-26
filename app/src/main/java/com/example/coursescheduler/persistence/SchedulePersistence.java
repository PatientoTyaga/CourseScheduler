package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Schedule;

import java.util.List;


public interface SchedulePersistence {
    List<Schedule> getScheduleSequential();
}

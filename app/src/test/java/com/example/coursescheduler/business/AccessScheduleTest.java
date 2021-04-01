package com.example.coursescheduler.business;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.persistence.CoursePersistenceStub;
import com.example.coursescheduler.persistence.SchedulePersistenceStub;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessScheduleTest {

    private AccessSchedule accessSchedule;
    private SchedulePersistenceStub schedulePersistenceStub;

    @Before
    public void setUp() {
        schedulePersistenceStub = new SchedulePersistenceStub();
        this.accessSchedule = new AccessSchedule(schedulePersistenceStub);
    }

    @Test
    public void test1(){
        final Schedule schedule;
        System.out.println("\nStarting test AccessSchedule");
        final List<Schedule> schedules = accessSchedule.getScheduleSequential();
        //data load
        schedule = schedules.get(0);//?
        assertNotNull("First sequential Schedule shouldn't be null",schedule);
        //check same

        assertEquals(3010, schedule.getCourseID());
        assertEquals(46545, schedule.getStudentID());
        System.out.println("\nFinished test AccessSchedule");
    }
}

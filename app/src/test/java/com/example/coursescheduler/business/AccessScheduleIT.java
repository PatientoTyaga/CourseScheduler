package com.example.coursescheduler.business;

import android.util.Log;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.presentation.CourseActivity;
import com.example.coursescheduler.presentation.LoginActivity;
import com.example.coursescheduler.presentation.ScheduleActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest= "AndroidManifest.xml")

public class AccessScheduleIT {
    private AccessSchedule accessSchedule;
    private AccessStudent accessStudent;

    @Before
    public void setUp() throws IOException {
        final ScheduleActivity scheduleActivity = Robolectric.buildActivity(ScheduleActivity.class).create().get();
        this.accessStudent = new AccessStudent(scheduleActivity.getApplicationContext());
        this.accessSchedule = new AccessSchedule(scheduleActivity.getApplicationContext());
    }

    @Test
    public void testListSchedule() {
        final ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
        final Schedule schedule = new Schedule(7784215, 1010);
        final Student student = new Student(7784215, "Simran");

        accessStudent.insertStudent(student); //insert a student in database
        accessSchedule.insertSchedule(schedule); //insert a schedule for the newly added student
        scheduleArrayList.addAll(accessSchedule.getScheduleSequential(student)); //gets the schedule for the student argument

        assertNotNull("first sequential schedule should not be null", scheduleArrayList.get(0));
        assertEquals(1010,(scheduleArrayList.get(0).getCourseID()));
        System.out.println("Finished test AccessSchedule getScheduleListForStudent");
    }

    @Test
    public void testInsertSchedule(){
        final ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
        final Schedule schedule = new Schedule(7784215, 1010);
        final Student student = new Student(7784215, "Simran");

        accessStudent.insertStudent(student); //insert a student in database
        accessSchedule.insertSchedule(schedule); //insert a schedule for the newly added student

        assertEquals(7784215,accessSchedule.getScheduleSequential(student).get(0).getStudentID());
    }

    @Test
    public void testDeleteSchedule(){
        final ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
        final Schedule schedule = new Schedule(7784215, 1010);
        final Student student = new Student(7784215, "Simran");

        accessStudent.insertStudent(student); //insert a student in database
        accessSchedule.insertSchedule(schedule); //insert a schedule for the newly added student
        accessSchedule.deleteSchedule(student); //delete the schedule for the student

        assertEquals(true, accessSchedule.getScheduleSequential(student).isEmpty());
    }

    @Test
    public void testDeleteCourse(){
        final ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
        final Schedule schedule1 = new Schedule(7784215, 1010);
        final Schedule schedule2 = new Schedule(7784215, 1020);
        final Student student = new Student(7784215, "Simran");

        accessStudent.insertStudent(student); //insert a student in database
        accessSchedule.insertSchedule(schedule1); //insert a schedule for the newly added student
        accessSchedule.insertSchedule(schedule2); //insert a schedule for the newly added student

        assertEquals(1010, accessSchedule.getScheduleSequential(student).get(0).getCourseID()); //will check if the course is there

        accessSchedule.deleteCourse(schedule1); //delete the course 1010 from the schedule for the student

        assertNotEquals(1010, accessSchedule.getScheduleSequential(student).get(0).getCourseID()); //checks if the course is deleted
    }

    @After
    public void destroy() throws Exception {
        final ActivityController<ScheduleActivity> scheduleActivity = Robolectric.buildActivity(ScheduleActivity.class).create().destroy();
    }
}

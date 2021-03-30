package com.example.coursescheduler.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScheduleTest {


    @Test
    public void constructorTest(){
        Course newCourse = new Course(1010, "INTRO TO COMP SCI", "9:30-10:45", "TR");
        Student newStudent = new Student(7888888,"Greta Thunberg");
        Schedule newSchedule = new Schedule(newStudent.getStudentID(),newCourse.getCourseId());

        assertNotNull(newSchedule);
        assertEquals(1010,(newSchedule.getCourseID()));
        assertEquals(7888888,(newSchedule.getStudentID()));
//        assertTrue("Schedule1".equals(newSchedule.getScheduleName()));

    }

    @Test
    public void testEquals() {
        Student newStudent1 = new Student(1234,"Greta Thunberg");
        Student newStudent2 = new Student(2345,"Anti Greta");
        Course newCourse1 = new Course(1010, "COMP1010", "11:30-12:30", "MWF");
        Course newCourse2 = new Course(1020, "COMP1020", "11:30-12:30", "MWF");
        Schedule newSchedule1 = new Schedule(newStudent1.getStudentID(),newCourse1.getCourseId());
        Schedule newSchedule2 = new Schedule(newStudent1.getStudentID(),newCourse1.getCourseId());
        Schedule newSchedule3 = new Schedule(newStudent2.getStudentID(),newCourse2.getCourseId());

        assertTrue(newSchedule1.equals(newSchedule1));
        assertTrue(newSchedule1.equals(newSchedule2));
        assertFalse((newSchedule1.equals(newSchedule3)));

    }

    @Test
    public void testHashCode() {
        Student newStudent1 = new Student(1234,"Greta Thunberg");
        Student newStudent2 = new Student(2345,"Anti Greta");
        Course newCourse1 = new Course(1010, "COMP1010", "11:30-12:30", "MWF");
        Course newCourse2 = new Course(1020, "COMP1020", "11:30-12:30", "MWF");
        Schedule newSchedule1 = new Schedule(newStudent1.getStudentID(),newCourse1.getCourseId());
        Schedule newSchedule2 = new Schedule(newStudent1.getStudentID(),newCourse1.getCourseId());
        Schedule newSchedule3 = new Schedule(newStudent2.getStudentID(),newCourse2.getCourseId());

        assertEquals(newSchedule1.hashCode(), newSchedule1.hashCode());
        assertEquals(newSchedule1.hashCode(), newSchedule2.hashCode());
        assertNotEquals(newSchedule1.hashCode(), newSchedule3.hashCode());
    }
}
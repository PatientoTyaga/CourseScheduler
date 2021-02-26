package com.example.coursescheduler.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScheduleTest {


    @Test
    public void constructorTest(){
        Student newStudent = new Student("7888888","Greta Thunberg");
        Course newCourse = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        Schedule newSchedule = new Schedule(newStudent,newCourse);

        assertNotNull(newSchedule);
        assertTrue("Intro to COMP".equals(newSchedule.getCourseName()));
        assertTrue("COMP1010".equals(newSchedule.getCourseID()));
        assertTrue("1".equals(newSchedule.getCourseTime()));
        assertTrue("7888888".equals(newSchedule.getStudentID()));
        assertTrue("Greta Thunberg".equals(newSchedule.getStudentName()));


    }

    @Test
    public void testEquals() {
        Student newStudent1 = new Student("7888888","Greta Thunberg");
        Student newStudent2 = new Student("7888888","Anti Greta");
        Course newCourse = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        Schedule newSchedule1 = new Schedule(newStudent1,newCourse);
        Schedule newSchedule2 = new Schedule(newStudent1,newCourse);
        Schedule newSchedule3 = new Schedule(newStudent2,newCourse);
        assertTrue(newSchedule1.equals(newSchedule1));
        assertTrue(newSchedule1.equals(newSchedule2));
        assertFalse((newSchedule1.equals(newSchedule3)));


    }

    @Test
    public void testHashCode() {
        Student newStudent1 = new Student("7888888","Greta Thunberg");
        Student newStudent2 = new Student("7888888","Anti Greta");
        Course newCourse = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        Schedule newSchedule1 = new Schedule(newStudent1,newCourse);
        Schedule newSchedule2 = new Schedule(newStudent1,newCourse);
        Schedule newSchedule3 = new Schedule(newStudent2,newCourse);

        assertEquals(newSchedule1.hashCode(),newSchedule1.hashCode());
        assertEquals(newSchedule1.hashCode(),newSchedule2.hashCode());
        assertNotEquals(newSchedule1.hashCode(),newSchedule3.hashCode());
    }
}
package com.example.coursescheduler.objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructorTest(){
        Course newCourse = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        assertNotNull(newCourse);
        assertTrue("Intro to COMP".equals(newCourse.getCourseName()));
        assertTrue("COMP1010".equals(newCourse.getCourseId()));
        assertTrue("1".equals(newCourse.getCourseTime()));

    }

    @Test
    public void getCourseName() {
    }

    @Test
    public void getCourseId() {
    }

    @Test
    public void getCourseTime() {
    }

    @Test
    public void getCourseDay() {
    }

    @Test
    public void testEquals() {
        Course newCourse1 = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        Course newCourse2 = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        assertNotNull(newCourse1);
        assertNotNull(newCourse2);
        assertTrue(newCourse1.getCourseName().equals(newCourse2.getCourseName()));
        assertTrue(newCourse1.getCourseId().equals(newCourse2.getCourseId()));
        assertTrue(newCourse1.getCourseTime().equals(newCourse2.getCourseTime()));
        assertTrue(newCourse1.getCourseDay().equals(newCourse2.getCourseDay()));

    }

    @Test
    public void testHashCode() {
        Course newCourse1 = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        Course newCourse2 = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        assertNotNull(newCourse1);
        assertNotNull(newCourse2);
        assertEquals(newCourse1.hashCode(),newCourse2.hashCode());
    }
}
package com.example.coursescheduler.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void constructorTest(){
        Course newCourse = new Course(1010, "INTRO TO COMP SCI", "9:30-10:45", "TR");
        assertNotNull(newCourse);
        assertTrue("INTRO TO COMP SCI".equals(newCourse.getCourseName()));
        assertEquals(1010, newCourse.getCourseId());
        assertTrue("9:30-10:45".equals(newCourse.getCourseTime()));
        assertTrue("TR".equals(newCourse.getCourseDay()));

    }


    @Test
    public void testEquals() {
        Course newCourse1 = new Course(1010, "INTRO TO COMP SCI", "9:30-10:45", "TR");
        Course newCourse2 = new Course(1010, "INTRO TO COMP SCI", "9:30-10:45", "TR");
        Course newCourse3 = new Course(1010, "INTRO TO COMP SCI", "9:30-10:30", "TR");

        assertNotNull(newCourse1);
        assertNotNull(newCourse2);
        assertFalse(newCourse1.equals(newCourse3));
        assertTrue(newCourse1.getCourseName().equals(newCourse2.getCourseName()));
        assertEquals(newCourse1.getCourseId(),(newCourse2.getCourseId()));
        assertTrue(newCourse1.getCourseTime().equals(newCourse2.getCourseTime()));
        assertTrue(newCourse1.getCourseDay().equals(newCourse2.getCourseDay()));

    }

    @Test
    public void testHashCode() {
        Course newCourse1 = new Course(1010, "INTRO TO COMP SCI", "9:30-10:45", "TR");
        Course newCourse2 = new Course(1010, "INTRO TO COMP SCI", "9:30-10:45", "TR");
        Course newCourse3 = new Course(1010, "INTRO TO COMP SCI", "9:30-10:30", "TR");

        assertNotNull(newCourse1);
        assertNotNull(newCourse2);
        assertEquals(newCourse1.hashCode(),newCourse2.hashCode());
        assertNotEquals(newCourse1.hashCode(),newCourse3.hashCode());
    }
}
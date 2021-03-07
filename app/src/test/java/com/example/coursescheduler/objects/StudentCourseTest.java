package com.example.coursescheduler.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentCourseTest {


    @Test
    public void constructorTest(){
        Student newStudent = new Student("7888888","Greta Thunberg");
        Course newCourse = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        StudentCourse newStudentCourse = new StudentCourse(newStudent,newCourse);

        assertNotNull(newStudentCourse);
        assertTrue("Intro to COMP".equals(newStudentCourse.getCourseName()));
        assertTrue("COMP1010".equals(newStudentCourse.getCourseID()));
        assertTrue("1".equals(newStudentCourse.getCourseTime()));
        assertTrue("7888888".equals(newStudentCourse.getStudentID()));
        assertTrue("Greta Thunberg".equals(newStudentCourse.getStudentName()));


    }

    @Test
    public void testEquals() {
        Student newStudent1 = new Student("7888888","Greta Thunberg");
        Student newStudent2 = new Student("7888888","Anti Greta");
        Course newCourse = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        StudentCourse newStudentCourse1 = new StudentCourse(newStudent1,newCourse);
        StudentCourse newStudentCourse2 = new StudentCourse(newStudent1,newCourse);
        StudentCourse newStudentCourse3 = new StudentCourse(newStudent2,newCourse);
        assertTrue(newStudentCourse1.equals(newStudentCourse1));
        assertTrue(newStudentCourse1.equals(newStudentCourse2));
        assertFalse((newStudentCourse1.equals(newStudentCourse3)));


    }

    @Test
    public void testHashCode() {
        Student newStudent1 = new Student("7888888","Greta Thunberg");
        Student newStudent2 = new Student("7888888","Anti Greta");
        Course newCourse = new Course("Intro to COMP", "COMP1010", "1", "MWF");
        StudentCourse newStudentCourse1 = new StudentCourse(newStudent1,newCourse);
        StudentCourse newStudentCourse2 = new StudentCourse(newStudent1,newCourse);
        StudentCourse newStudentCourse3 = new StudentCourse(newStudent2,newCourse);

        assertEquals(newStudentCourse1.hashCode(), newStudentCourse1.hashCode());
        assertEquals(newStudentCourse1.hashCode(), newStudentCourse2.hashCode());
        assertNotEquals(newStudentCourse1.hashCode(), newStudentCourse3.hashCode());
    }
}
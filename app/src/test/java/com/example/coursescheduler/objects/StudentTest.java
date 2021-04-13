package com.example.coursescheduler.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {


    @Test
    public void constructorTest(){
        Student newStudent = new Student(784666,"Greta Thunberg");
        assertNotNull(newStudent);
        assertEquals(784666,(newStudent.getStudentID()));
        assertTrue("Greta Thunberg".equals(newStudent.getStudentName()));


    }


    @Test
    public void testEquals() {
        Student newStudent1 = new Student(784666,"Greta Thunberg");
        Student newStudent2 = new Student(784666,"Greta Thunberg");
        Student newStudent3 = new Student(784556,"Not Greta");
        Student newStudent4 = new Student(784666,"Greta Thunberg");
        assertNotNull(newStudent1);
        assertNotNull(newStudent2);
        assertNotNull(newStudent3);
        assertNotNull(newStudent4);
        assertTrue((newStudent1.equals(newStudent1)));
        assertTrue(newStudent1.equals(newStudent2));
        assertFalse(newStudent1.equals(newStudent3));
        assertTrue(newStudent1.equals(newStudent4));


    }

    @Test
    public void testHashCode() {
        Student newStudent1 = new Student(7888888,"Greta Thunberg");
        Student newStudent2 = new Student(7888888,"Greta Thunberg");
        Student newStudent3 = new Student(7888888,"Anti Greta");
        assertNotNull(newStudent1);
        assertNotNull(newStudent2);
        assertNotNull(newStudent3);
        assertEquals(newStudent1.hashCode(),newStudent2.hashCode());
        assertNotEquals(newStudent1.hashCode(),newStudent3.hashCode());
    }
}
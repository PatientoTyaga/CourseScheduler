package com.example.coursescheduler.objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructorTest(){
        Student newStudent = new Student("7888888","Greta Thunberg");
        assertNotNull(newStudent);
        assertTrue("7888888".equals(newStudent.getStudentID()));
        assertTrue("Greta Thunberg".equals(newStudent.getStudentName()));


    }

    @Test
    public void getStudentID() {
    }

    @Test
    public void getStudentName() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testHashCode() {
    }
}
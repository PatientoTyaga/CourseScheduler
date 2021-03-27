package com.example.coursescheduler.business;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import java.io.File;

import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.objects.Student;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.example.coursescheduler.persistence.StudentPersistenceStub;

public class AccessStudentsTest {

    private AccessStudent accessStudents;
    private StudentPersistenceStub studentPersistence;

    @Before
    public void setUp() {
        studentPersistence = new StudentPersistenceStub();
        this.accessStudents = new AccessStudent(studentPersistence);
    }

    @Test
    public void test1(){
        final Student student;
        System.out.println("\nStarting test AccessStudent");

        final List<Student> students = accessStudents.getStudentSequential();
        //data load
        student = accessStudents.getStudentSequential().get(0);

        assertNotNull("First sequential student shouldn't be null",student);
        //check same
        assertEquals(7777777, student.getStudentID());

        System.out.println("\nFinished test AccessStudent");
    }
}

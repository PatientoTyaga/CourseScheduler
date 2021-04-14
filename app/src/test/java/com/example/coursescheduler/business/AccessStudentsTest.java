package com.example.coursescheduler.business;

import org.junit.Test;
import org.junit.Before;

import com.example.coursescheduler.objects.Student;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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
        student = students.get(0);
        assertNotNull("First sequential student shouldn't be null",student);
        //check same
        assertEquals(7834177, student.getStudentID());
        System.out.println("\nFinished test AccessStudent");
    }

}

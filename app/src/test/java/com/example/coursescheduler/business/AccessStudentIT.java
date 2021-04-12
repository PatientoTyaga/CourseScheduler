package com.example.coursescheduler.business;

import android.util.Log;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.presentation.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest= "AndroidManifest.xml")

public class AccessStudentIT {
    private AccessStudent accessStudent;

    @Before
    public void setUp() throws IOException {
        final LoginActivity loginActivity = Robolectric.buildActivity(LoginActivity.class).create().get();
        this.accessStudent = new AccessCourse(loginActivity.getApplicationContext());
    }
    @Test
    public void testListStudent() {
        final ArrayList<Student> studentArrayList = new ArrayList<>();
        final Student student;
        studentArrayList.addAll(accessStudent.getStudentSequential());
        Log.i("myTag", "student: " + studentArrayList.get(0));
        student = studentArrayList.get(0);
        assertNotNull("first sequential student should not be null", student);
        System.out.println("Finished test AccessStudents");
    }
    @Test
    public void testfetchStudent() {
        final ArrayList<Student> studentArrayList = new ArrayList<>();
        final Student student = new Student(7834178, "Guannan zhu");
        studentArrayList.addAll(accessStudent.getStudentSequential());
        assertEquals(7834178, accessStudent.fetchStudent(student).getStudentId());
    }
    @Test
    public void testinsertStudent(){
        final Student s = new Student(7834179, "Guannan wang");
        accessStudent.insertStudent(s);
        assertEquals(7834179,accessStudent.fetchStudent(s).getStudentId());
    }
    @Test
    public void testdeleteStudent(){
        final ArrayList<Student> studentArrayList = new ArrayList<>();
        final Student student;
        studentArrayList.addAll(accessStudent.getStudentSequential());
        student = studentArrayList.get(0);

        accessStudent.deleteStudent(student);

        //assertEquals(null,accessStudent.fetchStudent(student));
    }
    public void testupdateStudent(){
        final Student su = new Student(7834177, "Guannan dan");
        accessStudent.updateStudent(su);
        assertEquals(7834177,accessStudent.fetchStudent(su).getStudentId());
        assertEquals("Guannan dan",accessStudent.fetchStudent(su).getStudentName());
    }
}

package com.example.coursescheduler.business;

import android.util.Log;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.presentation.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest= "AndroidManifest.xml")

public class AccessStudentIT {
    private AccessStudent accessStudent;

    @Before
    public void setUp() throws IOException {
        final LoginActivity loginActivity = Robolectric.buildActivity(LoginActivity.class).create().get();
        this.accessStudent = new AccessStudent(loginActivity.getApplicationContext());
    }
    @Test
    public void testListStudent() {
        final ArrayList<Student> studentArrayList = new ArrayList<>();
        final Student student;
        final Student s = new Student(2222222, "Mohammad"); //add a course to the student Table
        accessStudent.insertStudent(s);
        studentArrayList.addAll(accessStudent.getStudentSequential()); //get all the entries from the student table i.e. the newly added student
        Log.i("myTag", "student: " + studentArrayList.get(0));
        student = studentArrayList.get(0);
        assertNotNull("first sequential student should not be null", student);
        System.out.println("Finished test AccessStudents");
    }
    @Test
    public void testFetchStudent() {
        final ArrayList<Student> studentArrayList = new ArrayList<>();
        final Student s = new Student(1111111, "Rusty"); //add a student to be fetched
        accessStudent.insertStudent(s);

        studentArrayList.addAll(accessStudent.getStudentSequential());
        assertEquals(1111111, accessStudent.fetchStudent(s).getStudentID());
    }
    @Test
    public void testInsertStudent(){
        Student s = new Student(1234567, "Patient");
        accessStudent.insertStudent(s);
        assertEquals(1234567,accessStudent.fetchStudent(s).getStudentID());
    }
    @Test
    public void testDeleteStudent(){
        final Student student = new Student(7784215, "Simran"); //add a student to the table
        accessStudent.insertStudent(student);
        accessStudent.deleteStudent(student); //delete the student from the table
        assertNull(accessStudent.fetchStudent(student).getStudentName());
    }
    @Test
    public void testUpdateStudent(){
        final Student student = new Student(7834177, "Ricky");
        accessStudent.insertStudent(student); // insert the student to the student table first

        final Student new_Student = new Student(7834177, "Guannan wang");
        accessStudent.updateStudent(new_Student); //update the student with that id to be Ricky

        assertEquals(7834177,accessStudent.fetchStudent(new_Student).getStudentID());
        assertEquals("Guannan wang",accessStudent.fetchStudent(new_Student).getStudentName());
    }

    @After
    public void destroy() throws Exception {
        final ActivityController<LoginActivity> loginActivity = Robolectric.buildActivity(LoginActivity.class).create().destroy();
    }

}

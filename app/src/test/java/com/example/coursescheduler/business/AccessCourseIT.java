package com.example.coursescheduler.business;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import android.content.Context;
import android.util.Log;

import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.persistence.CoursePersistenceStub;
import com.example.coursescheduler.persistence.IDatabase;
import com.example.coursescheduler.business.AccessCourse;
import com.example.coursescheduler.persistence.sqlite_db.CoursePersistence;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class AccessCourseIT {
    private AccessCourse accessCourse;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        //this.tempDB = ;
        //final CoursePersistence coursePersistence = new CoursePersistence(this.tempDB.getAbsolutePath().replace(".script", ""));

        //this.accessCourse = new AccessCourse(coursePersistence);
        CoursePersistenceStub coursePersistenceStub = new CoursePersistenceStub();
        this.accessCourse = new AccessCourse(coursePersistenceStub);
    }
    @Test
    public void testListCourses() {
        final List<Course> courses;
        final Course course;
        courses = accessCourse.getCourseSequential();
        course = courses.get(0);
        assertNotNull("first sequential course should not be null", course);
        assertEquals(3010,(course.getCourseId()));
        System.out.println("Finished test AccessCourses");
    }




}

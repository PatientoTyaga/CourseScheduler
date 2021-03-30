package com.example.coursescheduler.business;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import java.io.File;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.CoursePersistenceStub;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessCoursesTest {
    private AccessCourse accessCourse;
    private CoursePersistenceStub coursePersistenceStub;

    @Before
    public void setUp() {
        coursePersistenceStub = new CoursePersistenceStub();
        this.accessCourse = new AccessCourse(coursePersistenceStub);
    }
    @Test
    public void test1(){
        final Course course;
        System.out.println("\nStarting test AccessCourse");
        final List<Course> courses = accessCourse.getCourseSequential();
        //data load
        course = courses.get(0);
        assertNotNull("First sequential course shouldn't be null",course);
        //check same
        assertEquals(3010, course.getCourseId());

        System.out.println("\nFinished test AccessCourse");
    }
}

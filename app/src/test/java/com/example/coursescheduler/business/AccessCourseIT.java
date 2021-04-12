package com.example.coursescheduler.business;

import android.util.Log;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.presentation.CourseActivity;
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
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest= "AndroidManifest.xml")
public class AccessCourseIT {
    private AccessCourse accessCourse;

    @Before
    public void setUp() throws IOException {
        final CourseActivity courseActivity = Robolectric.buildActivity(CourseActivity.class).create().get();
        this.accessCourse = new AccessCourse(courseActivity.getApplicationContext());
    }
    @Test
    public void testListCourses() {
        final ArrayList<Course> courseArrayList = new ArrayList<>();
        final Course course;
        courseArrayList.addAll(accessCourse.getCourseSequential());
        Log.i("myTag", "course: " + courseArrayList.get(0));
        course = courseArrayList.get(0);
        assertNotNull("first sequential course should not be null", course);
        assertEquals(1010,(course.getCourseId()));
        System.out.println("Finished test AccessCourses");
    }
    @Test
    public void testFetchStudent() {
        final Course course = new Course(1010, "INTRO TO COMP SCI", "9:30-10:45", "TR");
        assertEquals(1010, accessCourse.fetchStudent(course).getCourseId());
    }
    @Test
    public void testInsertCourse(){
        final Course c = new Course(1012, "INTRO TO COMP SCI PY", "9:30-10:45", "TR");
        accessCourse.insertCourse(c);
        assertEquals(1012,accessCourse.fetchStudent(c).getCourseId());
    }

    @After
    public void destroy() throws Exception {
        final ActivityController<CourseActivity> courseActivity = Robolectric.buildActivity(CourseActivity.class).create().destroy();
    }

}

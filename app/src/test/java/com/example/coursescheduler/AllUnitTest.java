package com.example.coursescheduler;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.example.coursescheduler.business.AccessScheduleTest;
import com.example.coursescheduler.business.AccessStudentsTest;
import com.example.coursescheduler.business.AccessCoursesTest;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.CourseTest;
import com.example.coursescheduler.objects.ScheduleTest;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.objects.StudentTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseTest.class,
        StudentTest.class,
        ScheduleTest.class,
        AccessStudentsTest.class,
        AccessCoursesTest.class,
        AccessScheduleTest.class
})

public class AllUnitTest {

}

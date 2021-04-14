package com.example.coursescheduler;

import com.example.coursescheduler.business.AccessCourseIT;
import com.example.coursescheduler.business.AccessScheduleIT;
import com.example.coursescheduler.business.AccessStudentIT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessScheduleIT.class,
        AccessCourseIT.class,
        AccessStudentIT.class

})

public class All_IT_Test {
}

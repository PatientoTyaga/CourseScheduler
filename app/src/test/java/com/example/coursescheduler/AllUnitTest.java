package com.example.coursescheduler;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.example.coursescheduler.business.AccessStudentsTest;
import com.example.coursescheduler.business.AccessCoursesTest;
@RunWith(Suite.class)
@Suite.SuiteClasses({

        AccessStudentsTest.class,
        AccessCoursesTest.class
})

public class AllUnitTest {

}

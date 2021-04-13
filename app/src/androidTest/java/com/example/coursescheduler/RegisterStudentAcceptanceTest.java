package com.example.coursescheduler;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.persistence.IStudent;
import com.example.coursescheduler.presentation.LoginActivity;

import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.click;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterStudentAcceptanceTest {

    private static final String STUDENT_NAME = "John";
    private static final String STUDENT_ID = "1234567";
    private static AccessStudent accessStudent;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setupDatabase(){
        final LoginActivity loginActivity = Robolectric.buildActivity(LoginActivity.class).create().get();
//        iStudent = Services.getStudentPersistence(loginActivity.getApplicationContext());
        this.accessStudent = new AccessStudent(loginActivity.getApplicationContext());
    }

    @AfterClass
    public static void destroy() throws Exception {
        final ActivityController<LoginActivity> loginActivity = Robolectric.buildActivity(LoginActivity.class).create().destroy();
    }

    @Test
    public void LoginStudent(){
        //click on Register button in Login Page
        onView(withId(R.id.registerBtn_login)).perform(typeText(STUDENT_NAME));

        //enter Student name and ID to be registered
        onView(withId(R.id.studentID_register)).perform(typeText(STUDENT_ID));
        onView(withId(R.id.studentName_register)).perform(typeText(STUDENT_NAME));

        //click Login Button after Registering to take you back to login page
        onView(withId(R.id.loginBtn_register)).perform(click());

        //enter the registered student info in the login page
        onView(withId(R.id.studentID_login)).perform(typeText(STUDENT_ID));
        onView(withId(R.id.studentName_login)).perform(typeText(STUDENT_NAME));

        //click login button
        onView(withId(R.id.loginBtn_login)).perform(click());



    }


}

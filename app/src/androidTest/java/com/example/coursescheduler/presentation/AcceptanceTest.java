package com.example.coursescheduler.presentation;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.coursescheduler.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AcceptanceTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityTestRule = new ActivityScenarioRule<LoginActivity>(LoginActivity.class);

    @Test
    public void acceptanceTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.registerBtn_login), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.studentName_register),
                        childAtPosition(
                                allOf(withId(R.id.studentid),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("tom"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.studentID_register),
                        childAtPosition(
                                allOf(withId(R.id.studentid),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("2222222"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.studentID_register), withText("2222222"),
                        childAtPosition(
                                allOf(withId(R.id.studentid),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.registerBtn_register), withText("Register Student"),
                        childAtPosition(
                                allOf(withId(R.id.studentid),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.studentName_login),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("tom"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.studentID_login),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("2222222"), closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.loginBtn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.scheduleBtn_main), withText("Open Schedule Page"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.addScheduleBtn_schedule), withText("Add Schedule"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        materialButton5.perform(click());

        DataInteraction twoLineListItem = onData(anything())
                .inAdapterView(allOf(withId(R.id.courseList_course),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(0);
        twoLineListItem.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.addCourseBtn_course), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.addCourseBtn_schedule), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton7.perform(click());

        DataInteraction twoLineListItem2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.courseList_course),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(1);
        twoLineListItem2.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.addCourseBtn_course), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.addCourseBtn_schedule), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton9.perform(click());

        DataInteraction twoLineListItem3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.courseList_course),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(2);
        twoLineListItem3.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.addCourseBtn_course), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton10.perform(click());

        DataInteraction twoLineListItem4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.scheduleList_schedule),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(2);
        twoLineListItem4.perform(click());

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.deleteCourseBtn_schedule), withText("Delete Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction materialButton12 = onView(
                allOf(withId(R.id.addCourseBtn_schedule), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton12.perform(click());

        DataInteraction twoLineListItem5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.courseList_course),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(0);
        twoLineListItem5.perform(click());

        ViewInteraction materialButton13 = onView(
                allOf(withId(R.id.addCourseBtn_course), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton13.perform(click());

        DataInteraction twoLineListItem6 = onData(anything())
                .inAdapterView(allOf(withId(R.id.courseList_course),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                1)))
                .atPosition(3);
        twoLineListItem6.perform(click());

        ViewInteraction materialButton14 = onView(
                allOf(withId(R.id.addCourseBtn_course), withText("Add Course"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton14.perform(click());

        pressBack();

        ViewInteraction materialButton15 = onView(
                allOf(withId(R.id.logoutBtn_main), withText("Logout"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton15.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.studentName_login),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("tom"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.studentID_login),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("2222222"), closeSoftKeyboard());

        ViewInteraction materialButton16 = onView(
                allOf(withId(R.id.loginBtn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton16.perform(click());

        ViewInteraction materialButton17 = onView(
                allOf(withId(R.id.scheduleBtn_main), withText("Open Schedule Page"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton17.perform(click());

        ViewInteraction materialButton18 = onView(
                allOf(withId(R.id.deleteScheduleBtn_schedule), withText("Delete Schedule"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton18.perform(click());

        ViewInteraction materialButton19 = onView(
                allOf(withId(R.id.backToLogin_schedule), withText("Back"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        materialButton19.perform(click());

        ViewInteraction materialButton20 = onView(
                allOf(withId(R.id.editBtn_main), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton20.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.studentName_editText_main),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("tommy"), closeSoftKeyboard());

        ViewInteraction materialButton21 = onView(
                allOf(withId(R.id.updateBtn_main), withText("Update Student"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton21.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.studentName_login),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("tommy"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.studentID_login),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("2222222"), closeSoftKeyboard());

        ViewInteraction materialButton22 = onView(
                allOf(withId(R.id.loginBtn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton22.perform(click());

        ViewInteraction materialButton23 = onView(
                allOf(withId(R.id.editBtn_main), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton23.perform(click());

        ViewInteraction materialButton24 = onView(
                allOf(withId(R.id.deleteBtn_main), withText("Delete Student"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton24.perform(click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.studentName_editText_main),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("tommy"), closeSoftKeyboard());

        ViewInteraction materialButton25 = onView(
                allOf(withId(R.id.deleteBtn_main), withText("Delete Student"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton25.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

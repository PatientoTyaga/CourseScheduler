package com.example.coursescheduler.objects;

import java.util.Objects;

public class Course {

    private final String courseName;
    private final String courseId;
    private final String courseTime;
    private final String courseDay;

    public Course(final String courseName, final String courseId, final String courseTime,
                  final String courseDay){
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseTime = courseTime;
        this.courseDay = courseDay;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public String getCourseDay() {
        return courseDay;
    }

    public boolean equals(final Course o) {

        return Objects.equals(courseName, o.courseName) &&
                Objects.equals(courseId, o.courseId) &&
                Objects.equals(courseTime, o.courseTime) &&
                Objects.equals(courseDay, o.courseDay);
    }

    public int hashCode() {
        return Objects.hash(courseName, courseId, courseTime, courseDay);
    }
}

package com.example.coursescheduler.objects;

import java.util.Objects;

public class Course {

    private String courseName;
    private String courseId;
    private String courseTime;
    private String courseDay;

    public Course(){}

    public Course(final String courseId, final String courseName, final String courseTime,
                  final String courseDay){
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseTime = courseTime;
        this.courseDay = courseDay;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }

    public String getCourseTime() {
        return courseTime;
    }
    public void setCourseTime(String courseTime){
        this.courseTime = courseTime;
    }

    public String getCourseDay() {
        return courseDay;
    }
    public void setCourseDay(String courseDay){
        this.courseDay = courseDay;
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

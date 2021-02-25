package com.example.coursescheduler.objects;

import java.util.Objects;

public class SC {

    private final Student student;
    private final Course course;

    public SC(final Student student, final Course course){
        this.course = course;
        this.student = student;
    }

    public String getStudentID(){
        return (student.getStudentID());
    }

    public String getStudentName(){
        return (student.getStudentName());
    }

    public String getCourseID(){
        return (course.getCourseId());
    }

    public String getCourseName(){
        return (course.getCourseName());
    }

    public String getCourseTime(){
        return(course.getCourseTime());
    }


    public String toString() {
        return "SC{" +
                "student=" + student.getStudentID() +
                ", course=" + course.getCourseId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SC sc = (SC) o;
        return Objects.equals(student, sc.student) &&
                Objects.equals(course, sc.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}

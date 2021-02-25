package com.example.coursescheduler.objects;

import java.util.Objects;

public class Schedule {

    private final Student student;
    private final Course course;

    public Schedule(final Student student, final Course course){
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
        return "Schedule{" +
                "student=" + student.getStudentID() +
                ", course=" + course.getCourseId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(student, schedule.student) &&
                Objects.equals(course, schedule.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}

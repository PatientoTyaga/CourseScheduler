package com.example.coursescheduler.objects;

import java.util.ArrayList;
import java.util.Objects;

public class Schedule {

    private final String scheduleID;
    private final Student student;
    private final ArrayList<Course> courseArrayList;

    public Schedule(final String scheduleID, Student student, ArrayList<Course> courseArrayList){
        this.scheduleID = scheduleID;
        this.student = student;
        this.courseArrayList = courseArrayList;
    }

    public String getScheduleID(){
        return scheduleID;
    }

    public ArrayList<Course> getCourseList(){
        return courseArrayList;
    }

    public Student getStudent(){
        return student;
    }

    public Course getCourseAtPos(int pos){
        return courseArrayList.get(pos);
    }

    public void addToCourseList(Course course){
        courseArrayList.add(course);
    }

//    public String toString() {
//        return "Schedule{" +
//                "student=" + student.getStudentID() +
//                ", course=" + studentCourse.getCourseID() +
//                '}';
//    }

    public boolean equals(final Schedule o) {
        return Objects.equals(scheduleID, o.scheduleID) &&
                Objects.equals(student, o.student) &&
                Objects.equals(courseArrayList, o.courseArrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleID, student, courseArrayList);
    }
}

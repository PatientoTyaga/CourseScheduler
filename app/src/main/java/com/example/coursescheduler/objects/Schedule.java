package com.example.coursescheduler.objects;

import java.util.Objects;

public class Schedule {

    private String scheduleName;
    private int studentID;
    private int courseID;

    public Schedule(){}


    public Schedule(int studentID, int courseID){
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public String getScheduleName(){
        return scheduleName;
    }

    public int getCourseID(){
        return courseID;
    }

    public int getStudentID(){
        return studentID;
    }

    /*
    public void setScheduleName(String scheduleName){
        this.scheduleName = scheduleName;
    }

     */

    public void setCourseID(int courseID){
        this.courseID = courseID;
    }

    public void setStudent(int studentID){
        this.studentID = studentID;
    }

    public boolean equals(final Schedule o) {
        return Objects.equals(scheduleName, o.scheduleName) &&
                Objects.equals(studentID, o.studentID) &&
                Objects.equals(courseID, o.courseID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleName, studentID, courseID);
    }
}

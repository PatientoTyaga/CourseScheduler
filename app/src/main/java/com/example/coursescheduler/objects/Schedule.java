package com.example.coursescheduler.objects;

import java.util.Objects;

public class Schedule {

    private String scheduleName;
    private int studentID;
    private String courseName;

    public Schedule(String scheduleName, int studentID, String courseName){
        this.scheduleName = scheduleName;
        this.studentID = studentID;
        this.courseName = courseName;
    }

    public String getScheduleName(){
        return scheduleName;
    }

    public String getCourseName(){
        return courseName;
    }

    public int getStudentID(){
        return studentID;
    }

//    public void setScheduleID(int scheduleID){
//        this.scheduleID = scheduleID;
//    }

    public void setScheduleName(String scheduleName){
        this.scheduleName = scheduleName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setStudent(int studentID){
        this.studentID = studentID;
    }

    public boolean equals(final Schedule o) {
        return Objects.equals(scheduleName, o.scheduleName) &&
                Objects.equals(studentID, o.studentID) &&
                Objects.equals(courseName, o.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleName, studentID, courseName);
    }
}

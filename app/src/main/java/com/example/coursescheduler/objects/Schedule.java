package com.example.coursescheduler.objects;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Schedule {

    private int studentID;
    private int courseID;

    public Schedule(){}


    public Schedule(int studentID, int courseID){
        this.studentID = studentID;
        this.courseID = courseID;
    }


    public int getCourseID(){
        return courseID;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setStudent(int studentID){
        this.studentID = studentID;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean equals(final Schedule o) {
        return Objects.equals(studentID, o.studentID) &&
                Objects.equals(courseID, o.courseID);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(studentID, courseID);
    }
}

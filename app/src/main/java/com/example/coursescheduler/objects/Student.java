package com.example.coursescheduler.objects;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Student {

    private int studentID;
    private String studentName;

    //constructors
    public Student(){}

    public Student(final int studentID, final String studentName){
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public void setStudentID(int id){
        this.studentID = id;
    }
    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String name){
        this.studentName = name;
    }
    public String getStudentName() {
        return studentName;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentID, student.studentID) &&
                Objects.equals(studentName, student.studentName);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(studentID, studentName);
    }
}

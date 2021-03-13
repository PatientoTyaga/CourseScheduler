package com.example.coursescheduler.objects;

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

    //properties
    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String name){
        this.studentName = name;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentID, student.studentID) &&
                Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, studentName);
    }
}

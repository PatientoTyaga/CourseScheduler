package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Student;

import java.util.List;

public interface IAccessStudent {
    List<Student> getStudentSequential();
    void setCurrentStudent(Student student);
    Student getCurrentStudent();
}

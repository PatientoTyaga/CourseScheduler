package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Student;

import java.util.List;

public interface IStudentPersistence {
    List<Student> getStudentSequential();
    void setCurrentStudent(Student student);
    Student getCurrentStudent();
}

package com.example.coursescheduler.business;

import com.example.coursescheduler.Service.Service;
import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IStudentPersistence;

import java.util.Collections;
import java.util.List;

public class AccessStudent{


    private IStudentPersistence studentPersistence;
    private List<Student> students;
    private Student student;
    private int currentStudent;

    public AccessStudent(){
        studentPersistence = Services.getStudentPersistence();
        students = null;
        student = null;
        currentStudent = 0;
    }

    public AccessStudent(final IStudentPersistence studentPersistence){
        this();
        this.studentPersistence = studentPersistence;
    }

    public List<Student> getStudentSequential() {
        students = studentPersistence.getStudentSequential();
        return Collections.unmodifiableList(students);
    }


}

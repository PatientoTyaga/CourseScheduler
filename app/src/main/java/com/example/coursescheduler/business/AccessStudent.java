package com.example.coursescheduler.business;

import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IDatabase;

import java.util.Collections;
import java.util.List;

public class AccessStudent {


    private IDatabase studentPersistence;
    private List<Student> students;
    private Student student;
    private int currentStudent;

    public AccessStudent(){
        studentPersistence = Services.getStudentPersistence();
        students = null;
        student = null;
        currentStudent = 0;
    }

    public AccessStudent(final IDatabase studentPersistence){
        this();
        this.studentPersistence = studentPersistence;
    }

    public List<Student> getStudentSequential() {
        students = studentPersistence.getSequential();
        return Collections.unmodifiableList(students);
    }


}

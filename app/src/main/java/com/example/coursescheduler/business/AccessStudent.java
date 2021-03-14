package com.example.coursescheduler.business;

import android.content.Context;
import android.util.Log;

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

    public AccessStudent(Context context){
        studentPersistence = Services.getStudentPersistence(context);
        students = null;
        student = null;
        currentStudent = 0;
    }

//    public AccessStudent(final IDatabase studentPersistence){
//        this();
//        this.studentPersistence = studentPersistence;
//    }

    public List<Student> getStudentSequential() {
        students = studentPersistence.getSequential();
        return Collections.unmodifiableList(students);
    }


}

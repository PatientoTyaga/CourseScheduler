package com.example.coursescheduler.business;

import android.content.Context;
import android.util.Log;
import com.example.coursescheduler.application.Services;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IDatabase;
import com.example.coursescheduler.persistence.sqlite_db.StudentPersistence;

import java.util.Collections;
import java.util.List;

public class AccessStudent {
    private IDatabase studentPersistence;
    private List<Student> students;
    private Student student;

    public AccessStudent(Context context){
        studentPersistence = Services.getStudentPersistence(context);
        students = null;
        student = null;
    }

    public AccessStudent(final IDatabase studentPersistence) {
        this.studentPersistence = studentPersistence;
    }

    public List<Student> getStudentSequential() {
        students = studentPersistence.getSequential();
        return Collections.unmodifiableList(students);
    }

    public void insertStudent(Student student){
        studentPersistence.insert(student);
    }

    public void deleteStudent(Student student){
        studentPersistence.delete(student);
    }

    public Student fetchStudent(Student student) {
        this.student = (Student) studentPersistence.fetch(student);
        return this.student;
    }

    public void updateStudent (Student student){
        studentPersistence.update(student);
    }
}

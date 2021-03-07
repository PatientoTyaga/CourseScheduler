package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IStudentPersistence;

import java.util.Collections;
import java.util.List;

public class AccessStudent implements IAccessStudent{
    private IStudentPersistence studentPersistence;
    private List<Student> students;
    private Student currentStudent;

    public AccessStudent(IStudentPersistence studentPersistence){
        this.studentPersistence = studentPersistence;
        students = null;
    }

    @Override
    public List<Student> getStudentSequential() {
        students = studentPersistence.getStudentSequential();
        return Collections.unmodifiableList(students);
    }

    @Override
    public void setCurrentStudent(Student student) {
        studentPersistence.setCurrentStudent(student);
    }

    @Override
    public Student getCurrentStudent() {
        currentStudent = studentPersistence.getCurrentStudent();
        return currentStudent;
    }
}

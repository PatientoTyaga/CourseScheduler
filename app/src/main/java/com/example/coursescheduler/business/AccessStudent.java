package com.example.coursescheduler.business;

import com.example.coursescheduler.Service.Service;
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
        studentPersistence = Service.getStudentPersistence();
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

    public Student getSequential()
    {
        if (students == null)
        {
            students = studentPersistence.getStudentSequential();
            currentStudent = 0;
        }
        if (currentStudent < students.size())
        {
            student = students.get(currentStudent);
            currentStudent++;
        }
        else
        {
            students = null;
            student = null;
            currentStudent = 0;
        }
        return student;
    }


    public void setCurrentStudent(Student student) {
        studentPersistence.setCurrentStudent(student);
    }
}

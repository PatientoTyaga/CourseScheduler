package com.example.coursescheduler.persistence;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.coursescheduler.objects.Student;

public class StudentPersistenceStub implements IDatabase<Student> {
    private final List<Student> students = new ArrayList<>();

    public StudentPersistenceStub() {

        students.add(new Student(7834177, "Gary Chalmers"));
        students.add(new Student(7834567, "Selma Bouvier"));
        students.add(new Student(7845678, "Arnie Pye"));
        students.add(new Student(7812345, "Mary Bailey"));
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//    }

    @Override
    public void insert(Student currentStudent) {
        // don't bother checking for duplicates
        students.add(currentStudent);
    }

    @Override
    public boolean delete(Student currentStudent) {
        int index;

        index = students.indexOf(currentStudent);
        if (index >= 0)
        {
            students.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Student currentStudent) {
        int index;

        index = students.indexOf(currentStudent);
        if (index >= 0)
        {
            students.set(index, currentStudent);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getSequential() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public Student fetch(Student currentStudent) {
        //check if the parameter is in the list of student and then return the student object
                for(int i=0; i<students.size();i++) {
            if (currentStudent.equals(students.get(i))) {
                return currentStudent;
            }
        }
        return null;
    }
}

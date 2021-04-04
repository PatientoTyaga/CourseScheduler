package com.example.coursescheduler.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.coursescheduler.objects.Course;

public class CoursePersistenceStub implements IDatabase<Course> {
    private final List<Course> courses = new ArrayList<>();

    public CoursePersistenceStub() {

        courses.add(new Course(3010,"Distributed Computing","4","5"));
        courses.add(new Course(3020, "Human-Computer Interaction","2","5"));
        courses.add(new Course(3350, "Software Engineering I","5","3"));
        courses.add(new Course(3380, "Databases","2","1"));
    }
    @Override
    public List<Course> getSequential() {
        return Collections.unmodifiableList(courses);
    }

    @Override
    public void insert(Course currentCourse) {
        // don't bother checking for duplicates
        courses.add(currentCourse);
    }

    @Override
    public boolean update(Course currentCourse) {
        int index;

        index = courses.indexOf(currentCourse);
        if (index >= 0)
        {
            courses.set(index, currentCourse);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Course currentCourse) {
        int index;

        index = courses.indexOf(currentCourse);
        if (index >= 0)
        {
            courses.remove(index);
            return true;
        }
        return false;
    }
    public Course fetch(Course currentCourse) {
        //check if the parameter is in the list of course and then return the course object
        for(int i=0; i<courses.size();i++) {
            if (currentCourse.equals(courses.get(i))) {
                return currentCourse;
            }
        }
        return null;
    }
}
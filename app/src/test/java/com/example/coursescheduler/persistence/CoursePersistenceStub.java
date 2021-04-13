package com.example.coursescheduler.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.coursescheduler.objects.Course;

public class CoursePersistenceStub implements ICourse {
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
    public ArrayList<Course> getCourses(ArrayList<Integer> courseIds) {
        ArrayList<Course> coursesArrayList = new ArrayList<Course>();

        courseIds.add(3010);
        courseIds.add(3020);
        courseIds.add(3350);
        courseIds.add(3380);

        coursesArrayList.add(new Course(courseIds.get(0), "Distributed Computing","4","5"));
        coursesArrayList.add(new Course(courseIds.get(1), "Human-Computer Interaction","2","5"));
        coursesArrayList.add(new Course(courseIds.get(2), "Software Engineering I","5","3"));
        coursesArrayList.add(new Course(courseIds.get(3), "Databases","2","1"));

        return coursesArrayList;
    }

    @Override
    public void insert(Course currentCourse) {
        // don't bother checking for duplicates
        courses.add(currentCourse);
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
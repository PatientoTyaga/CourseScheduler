package com.example.coursescheduler.business;

import com.example.coursescheduler.business.AccessCourse;
import com.example.coursescheduler.objects.Course;

import java.util.ArrayList;

public class CourseList {
    /*Creates a course of all the courses that will be provided to the user. The idea is to provide a list of courses to the user to choose from.
    * This method will create the course objects and add them to the Database Table for Course.
    * Once added the user would be able to access the list of courses.*/


    private ArrayList<Course> courseArrayList = new ArrayList<>();
    private AccessCourse accessCourse;
    public void createList(AccessCourse accessCourse){
        this.accessCourse = accessCourse;

        courseArrayList.add(new Course(1010, "Intro Computer Science", "14:30-15:45", "TR"));
        courseArrayList.add(new Course(1012, "Computer Programming for Scientists and Engineers", "11:30-12:20", "MWF"));
        courseArrayList.add(new Course(1500, "Computing: Ideas and Innovation",  "11:30-12:20", "MWF"));
        courseArrayList.add(new Course(1600, "Navigating Your Digital World", "10:30-11:20", "MWF"));

        courseArrayList.add(new Course(2080, "Analysis of Algorithms",  "16:00-17:15", "TR"));
        courseArrayList.add(new Course(2140, "Data Structures and Algorithms", "09:30-10:20", "MWF"));
        courseArrayList.add(new Course(2150, "Object Orientation",  "10:30-11:20", "MWF"));
        courseArrayList.add(new Course(2160, "Programming Practices",  "13:30-14:20", "TR"));
        courseArrayList.add(new Course(2280,"Introduction to Computer Systems",  "11:30-12:20", "MWF"));

        courseArrayList.add(new Course(3010, "Distributed Computing", "11:30-12:20", "MWF"));
        courseArrayList.add(new Course(3020, "Human-Computer Interaction 1", "11:20-12:30", "TR"));
        courseArrayList.add(new Course(3170, "Analysis of Algorithms and Data Structures", "10:30-11:20", "MWF"));
        courseArrayList.add(new Course(3190, "Introduction to Artificial Intelligence",  "09:30-10:20", "MWF"));
        courseArrayList.add(new Course(3350, "Software Engineering 1",  "11:30-12:45", "TR"));
        courseArrayList.add(new Course(3370, "Computer Organization", "08:30-09:45", "TR"));
        courseArrayList.add(new Course(3430, "Operating Systems", "13:30-14:20", "MWF"));
        courseArrayList.add(new Course(3490, "Computer Graphics 1",  "12:30-13:20", "MWF"));
        courseArrayList.add(new Course(3820, "Introduction to Bioinformatics Algorithms",  "14:30-15:45", "TR"));

        courseArrayList.add(new Course(4020, "Human-Computer Interaction 2", "10:00-11:15", "TR"));
        courseArrayList.add(new Course(4060, "Lower Bounds and Impossibility",  "14:30-15:45", "TR"));
        courseArrayList.add(new Course(4190, "Artificial Intelligence", "11:30-12:20", "MWF"));
        courseArrayList.add(new Course(4350, "Software Engineering 2", "11:30-12:45", "TR"));
        courseArrayList.add(new Course(4360, "Machine Learning",  "16:00-17:15", "TR"));
        courseArrayList.add(new Course(4380, "Database Implementation",  "14:30-15:45", "TR"));
        courseArrayList.add(new Course(4420, "Advanced Design and Analysis of Algorithms", "09:30-10:20", "MWF"));
        courseArrayList.add(new Course(4490, "Computer Graphics 2",  "10:30-11:20", "MWF"));
        courseArrayList.add(new Course(4550, "Real-Time Systems", "12:30-13:20", "MWF"));
        courseArrayList.add(new Course(4580, "Computer Security", "13:30-14:20", "MWF"));
        courseArrayList.add(new Course(4620, "Professional Practice in Computer Science",  "13:00-14:15", "TR"));

        for(Course c : courseArrayList){
            this.accessCourse.insertCourse(c);
        }
    }
}

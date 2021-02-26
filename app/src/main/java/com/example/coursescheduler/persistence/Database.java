package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class Database implements SchedulePersistence{

    private static Schedule s1;
    private static Schedule s2;
    private static Schedule s3;
    private static Schedule s4;

    public static ArrayList<Student> studentList = new ArrayList<Student>();
    public static ArrayList<Course> courseList = new ArrayList<Course>();
    public static ArrayList<Course> fallCourse = new ArrayList<Course>();
    public static ArrayList<Course> winterCourse = new ArrayList<Course>();
    public static String currentStudent = "dummy";

    public Database() {
        s1 = null;
        s2 = null;
        s3 = null;
        s4 = null;

        initData();
    }

    public static void initData() {
        Student student1 = new Student("7784215", "Simrandeep");
        Student student2 = new Student("7853346", "Mohammad");
        Student student3 = new Student("7850109", "Rusty");
        Student student4 = new Student("7840761", "Alan");
        Student student5 = new Student("7841354", "Verne");
        Student student6 = new Student("7854451", "Rudolf");
        Student student7 = new Student("7843879", "Norman");
        Student student8 = new Student("7846612", "Shirley");
        Student student9 = new Student("7841106", "Mamie");
        Student student10 = new Student("7849975", "Lucy");
        Student student11 = new Student("7847416", "Jill");


        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);
        studentList.add(student11);

        Course course1 = new Course("Intro Computer Science", "COMP1010", "08:30-09:30", "TR");
        Course course2 = new Course("Analysis of Algorithms", "Comp2080", "10:30-11:30", "TR");
        Course course3 = new Course("Object Orientation", "Comp2150", "10:30-11:30", "MWF");
        Course course4 = new Course("Human-Computer Interaction 1", "Comp3020", "11:20-12:30", "TR");


        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);

        s1 = new Schedule(student1, course1);
        s2 = new Schedule(student1, course2);
        s3 = new Schedule(student2, course3);
        s4 = new Schedule(student4, course4);

    }

    @Override
    public List<Schedule> getScheduleSequential() {
        List<Schedule> list = new ArrayList<Schedule>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        return list;
    }

}

//    public static String [] timeArea ={
//            "08:30-09:30",
//            "10:30-11:20",
//            "11:20-12:30",
//            "13:30-14:20"
//    };
//    //10 test students Info
//    public static String [][] studentInfo = {
//            { "Simrandeep", "7784215" },
//            { "Mohammad", "7853346" },
//            { "Rusty", "7850109"},
//            {"Alan","7840761"},
//            {"Verne","7841354"},
//            {"Rudolf", "7854451"},
//            {"Norman","7843879"},
//            {"Shirley","7846612"},
//            {"Mamie","7841106"},
//            {"Lucy","7849975"},
//            {"Jill","7847416"}
//    };
//
//    public static Student[] studentList = {
//            new Student("7784215", "Simrandeep"),
//            new Student("7853346", "Mohammad"),
//            new Student("7850109", "Rusty"),
//            new Student("7840761", "Alan"),
//            new Student("7841354", "Verne"),
//            new Student("7854451", "Rudolf"),
//            new Student("7843879", "Norman"),
//            new Student("7846612", "Shirley"),
//            new Student("7841106", "Mamie"),
//            new Student("7849975", "Lucy"),
//            new Student("7847416", "Jill"),
//    };
//
//    //10 test course Info
//    public static String [][] courseInfo = {
//            { "Comp1010", "Intro Computer Science 1", "08:30-09:30", "TR" },
//            { "Comp2080", "Analysis of Algorithms", "10:30-11:20", "MWF" },
//            { "Comp2150", "Object Orientation", "10:30-11:20", "MWF"},
//            { "Comp3020", "Human-Computer Interaction 1", "11:20-12:30", "TR" },
//            { "Comp3040", "Technical Communication", "10:30-11:20", "TR" },
//            { "Comp3350", "Software Engineering 1", "11:20-12:30", "MWF"},
//            { "Comp4380", "Database Implementation", "08:30-09:30", "TR" },
//            { "Stat2000", "Basic Statistical Analysis 2", "13:30-14:20", "MWF"},
//            { "Econ2010", "MicroEconomics Theory 1", "10:30-11:20", "TR"},
//            { "Econ2020", "MacroEconomics Theory 1", "10:30-11:20", "TR"}
//    };
//
//    public static Course[] courseList = {
//            new Course("Intro Computer Science", "COMP1010", "08:30-09:30", "TR"),
//            new Course("Analysis of Algorithms", "Comp2080", "10:30-11:30", "TR"),
//            new Course("Object Orientation", "Comp2150", "10:30-11:30", "MWF"),
//            new Course("Human-Computer Interaction 1", "Comp3020", "11:20-12:30", "TR"),
//    };

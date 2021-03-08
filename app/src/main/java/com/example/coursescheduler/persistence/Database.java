package com.example.coursescheduler.persistence;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class Database implements ISchedulePersistence, ICoursePersistence, IStudentPersistence {

    private static Schedule schedule1;
    private static Schedule schedule2;
    private static Schedule schedule3;

    public static ArrayList<Student> studentArrayList = new ArrayList<>();
    public static ArrayList<Course> courseArrayList = new ArrayList<>();
    public static ArrayList<Course> courseArrayList2 = new ArrayList<>();
//    public static ArrayList<Course> currentCourseArrayList = new ArrayList<Course>();
//
//    public static ArrayList<Schedule> currentScheduleList = new ArrayList<>();

    public static Student currentStudent;
    public static Course currentCourse;
    public static Schedule currentSchedule;

    public static ArrayList<Schedule> scheduleArrayList = new ArrayList<>();

    public Database() {
        schedule1 = null;
        schedule2 = null;
        schedule3 = null;

//        initData();
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

        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        studentArrayList.add(student5);
        studentArrayList.add(student6);
        studentArrayList.add(student7);
        studentArrayList.add(student8);
        studentArrayList.add(student9);
        studentArrayList.add(student10);
        studentArrayList.add(student11);

        Course course1 = new Course("Intro Computer Science", "COMP 1010", "08:30-09:30", "TR");
        Course course2 = new Course("Analysis of Algorithms", "COMP 2080", "10:30-11:30", "TR");
        Course course3 = new Course("Object Orientation", "COMP 2150", "10:30-11:30", "MWF");
        Course course4 = new Course("Human-Computer Interaction 1", "COMP 3020", "11:20-12:30", "TR");

        courseArrayList.add(course1);
        courseArrayList.add(course2);
        courseArrayList.add(course3);
        courseArrayList.add(course4);

        courseArrayList2.add(course1);
        courseArrayList2.add(course2);

        schedule1 = new Schedule("Schedule 1", student1, courseArrayList); //creates a schedule with Student 1 having 4 courses
        schedule2 = new Schedule("Schedule 2", student1, courseArrayList2); //creates a schedule with Student 1 having 4 courses
        schedule3 = new Schedule("Schedule 2", student3, courseArrayList); //creates a schedule with Student 3 having 4 courses

        scheduleArrayList.add(schedule1);
        scheduleArrayList.add(schedule2);
        scheduleArrayList.add(schedule3);

    }

//    @Override
//    public List<Schedule> getScheduleSequential() {
//        return scheduleArrayList;
//    }

    @Override
    public List<Schedule> getScheduleSequential(Student student) {
        ArrayList<Schedule> currentScheduleList = new ArrayList<>();
        for (Schedule s: scheduleArrayList) {
            if(s.getStudent().getStudentID().matches(student.getStudentID())){
                currentScheduleList.add(s);
            }
        }
        return currentScheduleList;
    }

    @Override
    public List<Course> getCourseSequential(){
        return courseArrayList;
    }

    @Override
    public void setCurrentCourse(Course course) {
        currentCourse = course;
    }

    @Override
    public Course getCurrentCourse() {
        return currentCourse;
    }

    @Override
    public List<Student> getStudentSequential(){ return studentArrayList; }

    @Override
    public void setCurrentStudent(Student student){
        currentStudent = student;
    }

    @Override
    public Student getCurrentStudent(){
        return currentStudent;
    }

    @Override
    public void addCourse(Course course) {
        currentSchedule.addToCourseList(course);
    }

    @Override
    public List<Course> getCourseList(Schedule schedule) {
        for (Schedule s: scheduleArrayList) {
            if(s.getScheduleID().matches(schedule.getScheduleID()) && s.getStudent().getStudentID().matches(schedule.getStudent().getStudentID())){
                return s.getCourseList();
            }
        }
        return null;
    }

    @Override
    public Schedule getCurrentSchedule() {
        return currentSchedule;
    }

    @Override
    public void setCurrentSchedule(Schedule schedule) {
        currentSchedule = schedule;
    }

}

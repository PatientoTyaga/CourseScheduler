package com.example.coursescheduler.business;

import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ValidatorCourse {

    public boolean courseTimeOverlap(Course courseToAdd, ArrayList<Course> courseArrayList){

        //method to ensure there is no course times overlapping
        //Takes first 4 chars from the changed courseTime that now lools like 1430-1545

        boolean toRet = false;
        int courseToAddStartTime=Integer.parseInt(courseToAdd.getCourseTime().replace(":","").substring(0,4));
        int courseToAddEndTime=Integer.parseInt(courseToAdd.getCourseTime().replace(":","").substring(5,9));

        for(int i=0; i<courseArrayList.size(); i++){
            if(courseArrayList.get(i).getCourseDay().equals(courseToAdd.getCourseDay())){
                int currentCourseStartTime=Integer.parseInt(courseArrayList.get(i).getCourseTime().replace(":","").substring(0,4));
                int currentCourseEndTime=Integer.parseInt(courseArrayList.get(i).getCourseTime().replace(":","").substring(5,9));

                if(courseToAddStartTime>=currentCourseStartTime && courseToAddStartTime<=currentCourseEndTime ||
                        courseToAddEndTime>=currentCourseStartTime && courseToAddEndTime <=currentCourseEndTime){
                    toRet = true;
                    break;
                }
            }
        }

        return toRet;
    }

    public boolean courseAlreadyAdded(Course courseToAdd, ArrayList<Integer> courseIds){

        //checks if course has already been added to schedule

        boolean toRet = false;
        for(int i =0; i < courseIds.size(); i++){
            if(courseIds.get(i) == courseToAdd.getCourseId()){
                toRet = true;
                break;
            }
        }

        return toRet;
    }


    public boolean scheduleIsEmpty(List<Schedule> schedule){
        //check if schedule is empty

        boolean toRet = false;
        if(schedule.isEmpty()){
            toRet = true;
        }
        return toRet;
    }
}

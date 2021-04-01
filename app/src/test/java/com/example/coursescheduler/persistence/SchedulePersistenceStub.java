package com.example.coursescheduler.persistence;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;


public class SchedulePersistenceStub implements ISchedule {
    private List<Schedule> schedule;

    public SchedulePersistenceStub() {
        this.schedule = new ArrayList<>();

        schedule.add(new Schedule(7834177,3010));
        schedule.add(new Schedule( 7834567,3020));
        schedule.add(new Schedule( 7845678,3350));
        schedule.add(new Schedule( 7812345,3380));
    }
    @Override
    public List<Schedule> getSequential(Student currentstudent) {
        List<Schedule> newSchedule = new ArrayList<Schedule>();
        for(int i = 0; i<schedule.size(); i++){
            if (schedule.get(i).getStudentID()==currentstudent.getStudentID())
                newSchedule.add(schedule.get(i));
        }

        return newSchedule;
    }

    @Override
    public void insert(Schedule currentSchedule) {
        // don't bother checking for duplicates
        schedule.add(currentSchedule);
    }

    @Override
    public boolean update(Schedule currentSchedule) {
        int index;

        index = schedule.indexOf(currentSchedule);
        if (index >= 0)
        {
            schedule.set(index, currentSchedule);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSchedule(Student deleteObject){
        for(int i = 0; i<schedule.size(); i++){
            if (schedule.get(i).getStudentID()==deleteObject.getStudentID())
                schedule.remove(i);
                return true;
        }
        return false;
    }

    @Override
    public boolean deleteCourse(Schedule deleteObject) {
        int index;

        index = schedule.indexOf(deleteObject);
        if (index >= 0)
        {
            schedule.remove(index);
            return true;
        }
        return false;
    }
    public Schedule fetch(Schedule currentSchedule) {
        //check if the parameter is in the list of course and then return the course object
        for(int i=0; i<schedule.size();i++) {
            if (currentSchedule.equals(schedule.get(i))) {
                return currentSchedule;
            }
        }
        return null;
    }
}

package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coursescheduler.R;
import com.example.coursescheduler.Service.Service;
import com.example.coursescheduler.business.AccessSchedule;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    private AccessSchedule accessSchedule;
    private ArrayAdapter<Schedule> scheduleArrayAdapter;
    private ArrayList<Schedule> scheduleList;
    private Student currentStudent;
    private int selectedSchedulePos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        try {
            accessSchedule = new AccessSchedule();
            scheduleList = new ArrayList<>();
            currentStudent = accessSchedule.getCurrentStudent(); //sets the current student that has opened the schedule
            scheduleList.addAll(accessSchedule.getScheduleSequential(currentStudent)); //adds the schedules that the currentStudent has to a list

            scheduleArrayAdapter = new ArrayAdapter<Schedule>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, scheduleList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    text1.setText(scheduleList.get(position).getScheduleID());
                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listViewSchedule);
            listView.setAdapter(scheduleArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Button addCourseToSchedule = (Button) findViewById(R.id.addCourseToSchedule);
                    if (position == selectedSchedulePos) {
                        listView.setItemChecked(position, false);
                        selectedSchedulePos = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        selectedSchedulePos = position;
                        selectScheduleAtPosition(position); //calls the method to set the current student in database
                        addCourseToSchedule.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                // Do something in response to button click
                                Intent scheduleIntent = new Intent(ScheduleActivity.this, CourseActivity.class); //Goes to ScheduleActivity Page
                                startActivity(scheduleIntent);
                            }
                        });
                    }
                }
            });
        } catch (final Exception e) {
            System.out.println(e);
        }
    }
    public void selectScheduleAtPosition(int position) {
        Schedule selected = scheduleArrayAdapter.getItem(position);
        accessSchedule.setCurrentSchedule(selected);
        Log.i("myTag", String.valueOf(selected.getCourseList()));

        try {
            TextView studentName = (TextView)findViewById(R.id.textScheduleStudentName);
            List<Course> courseList = new ArrayList<>();
            courseList.addAll(selected.getCourseList()); //adds the schedules that the currentStudent has to a list
            ArrayAdapter<Course> courseListAdaptor = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text2, courseList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                    text2.setText(courseList.get(position).getCourseId());
                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listViewScheduleCourse);
            listView.setAdapter(courseListAdaptor);
            studentName.setText(" " + selected.getStudent().getStudentName());
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
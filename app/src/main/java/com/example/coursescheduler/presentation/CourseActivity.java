package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coursescheduler.business.AccessCourse;
import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessSchedule;
import com.example.coursescheduler.objects.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private AccessSchedule accessSchedule;
    private AccessCourse accessCourse;
    private List<Course> courseList;
    private ArrayAdapter<Course> courseArrayAdapter;
    private int selectedCoursePos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        accessCourse = new AccessCourse();
        accessSchedule = new AccessSchedule();

        try {
            accessCourse.setCurrentCourse(null);
            courseList = new ArrayList<>();
            courseList.addAll(accessCourse.getCourseSequential());
            courseArrayAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, courseList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    text1.setText(courseList.get(position).getCourseId());
                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listView1);
            listView.setAdapter(courseArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Button addCourseButton = (Button) findViewById(R.id.addCourse);
                    if (position == selectedCoursePos) {
                        listView.setItemChecked(position, false);
                        addCourseButton.setEnabled(false);
                        selectedCoursePos = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        addCourseButton.setEnabled(true);
                        selectedCoursePos = position;
                        selectCourseAtPosition(position);

                        addCourseButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                // Do something in response to button click
                                accessSchedule.getCurrentSchedule().addToCourseList(accessSchedule.getCurrentCourse());
                                Intent scheduleIntent = new Intent(CourseActivity.this, ScheduleActivity.class); //Goes to ScheduleActivity Page
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

    public void selectCourseAtPosition(int position) {
        Course selected = courseArrayAdapter.getItem(position);
        accessCourse.setCurrentCourse(selected);

        TextView courseID = (TextView)findViewById(R.id.textCourseID);
        TextView courseName = (TextView)findViewById(R.id.textCourseName);
        TextView courseTime = (TextView)findViewById(R.id.textCourseTime);
        TextView courseDay = (TextView)findViewById(R.id.textCourseDay);

        courseID.setText("Course: "+ selected.getCourseId());
        courseName.setText("Name: "+ selected.getCourseName());
        courseTime.setText("Time: "+ selected.getCourseTime());
        courseDay.setText("Day: "+ selected.getCourseDay());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
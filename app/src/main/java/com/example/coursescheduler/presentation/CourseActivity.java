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
    private String studentID;
    private String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);



        Bundle b = getIntent().getExtras();
        if(b != null) {
            studentID = b.getString("studentID");
            studentName = b.getString("studentName");
        }

        accessCourse = new AccessCourse(this);
        Course c = new Course("COMP 1010", "Intro to Comp Sci", "08:00 - 09:00", "MWF");
        accessCourse.insertCourse(c);
        try {
            courseList = new ArrayList<>();
            courseList.add(c);
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

            final ListView listView = (ListView) findViewById(R.id.courseList_course);
            listView.setAdapter(courseArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Button addCourseButton = (Button) findViewById(R.id.addCourseBtn_course);
                    if (position == selectedCoursePos) {
                        listView.setItemChecked(position, false);
                        addCourseButton.setEnabled(false);
                        selectedCoursePos = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        addCourseButton.setEnabled(true);
                        selectedCoursePos = position;
                        Course selectedCourse = selectCourseAtPosition(position);

                        addCourseButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                // Do something in response to button click

                                Intent courseIntent = new Intent(CourseActivity.this, ScheduleActivity.class); //Goes to ScheduleActivity Page
                                courseIntent.putExtra("courseID", selectedCourse.getCourseId());
                                courseIntent.putExtra("courseName", selectedCourse.getCourseName());
                                courseIntent.putExtra("courseTime", selectedCourse.getCourseTime());
                                courseIntent.putExtra("courseDay", selectedCourse.getCourseDay());
                                courseIntent.putExtra("studentID", Integer.parseInt(studentID));
                                courseIntent.putExtra("studentName", studentName);
                                startActivity(courseIntent);
                            }
                        });
                    }
                }
            });
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    public Course selectCourseAtPosition(int position) {
        Course selected = courseArrayAdapter.getItem(position);

        TextView courseID = (TextView)findViewById(R.id.courseID_course);
        TextView courseName = (TextView)findViewById(R.id.courseName_course);
        TextView courseTime = (TextView)findViewById(R.id.courseTime_course);
        TextView courseDay = (TextView)findViewById(R.id.courseDay_course);

        courseID.setText("Course: "+ selected.getCourseId());
        courseName.setText("Name: "+ selected.getCourseName());
        courseTime.setText("Time: "+ selected.getCourseTime());
        courseDay.setText("Day: "+ selected.getCourseDay());

        return selected;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
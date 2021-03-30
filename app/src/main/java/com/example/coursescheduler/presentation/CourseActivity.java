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

import com.example.coursescheduler.business.AccessCourse;
import com.example.coursescheduler.R;
import com.example.coursescheduler.objects.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private AccessCourse accessCourse;
    private List<Course> courseList;
    private ArrayAdapter<Course> courseArrayAdapter;
    private int selectedCoursePos = -1;
    private String studentID;
    private String studentName;
    private static ArrayList<Course> courseArrayList = new ArrayList<>();
    private Button addCourseButton;

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

        try {
            addCourseButton = (Button) findViewById(R.id.addCourseBtn_course);
            courseList = new ArrayList<>();
            if(accessCourse.getCourseSequential().isEmpty()){
                getCourseList();
            }
            courseList.addAll(accessCourse.getCourseSequential());
            Log.i("myTag", "id: "+courseList.get(0).getCourseId()+", name: "+courseList.get(0).getCourseName()+", time: "+courseList.get(0).getCourseTime()+", day: "+courseList.get(0).getCourseDay());
            courseArrayAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, courseList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    text1.setText(courseList.get(position).getCourseName());
                    return view;
                }
            };

            addCourseButton.setEnabled(false);

            final ListView listView = (ListView) findViewById(R.id.courseList_course);
            listView.setAdapter(courseArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
                                courseIntent.putExtra("courseID", String.valueOf(selectedCourse.getCourseId()));
                                courseIntent.putExtra("courseName", selectedCourse.getCourseName());
                                courseIntent.putExtra("courseTime", selectedCourse.getCourseTime());
                                courseIntent.putExtra("courseDay", selectedCourse.getCourseDay());
                                courseIntent.putExtra("studentID", studentID);
                                courseIntent.putExtra("studentName", studentName);
                                startActivity(courseIntent);
                                finish();
                            }
                        });
                    }
                }
            });
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    protected void getCourseList(){
        //add the course to the database if not there.
        //can put the course list in a file and use the file to return values to be added in the database
        Course course1 = new Course(1010, "Intro Computer Science", "08:30-09:30", "TR");
        Course course2 = new Course(2080,"Analysis of Algorithms",  "10:30-11:30", "TR");
        Course course3 = new Course(2150,"Object Orientation",  "10:30-11:30", "MWF");
        Course course4 = new Course(3020, "Human-Computer Interaction 1", "11:20-12:30", "TR");

        courseArrayList.add(course1);
        courseArrayList.add(course2);
        courseArrayList.add(course3);
        courseArrayList.add(course4);

        for(Course c : courseArrayList){
            accessCourse.insertCourse(c);
        }

        Log.i("myTag", "courseList: " + accessCourse.getCourseSequential());
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
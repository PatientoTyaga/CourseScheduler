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
import android.widget.Toast;

import com.example.coursescheduler.Message;
import com.example.coursescheduler.Variables;
import com.example.coursescheduler.business.AccessCourse;
import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessSchedule;
import com.example.coursescheduler.business.ValidatorCourse;
import com.example.coursescheduler.business.CourseList;
import com.example.coursescheduler.business.exceptions.DuplicateCourseException;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Schedule;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private AccessCourse accessCourse;
    private ValidatorCourse validatorCourse;
    private AccessSchedule accessSchedule;
    private List<Course> courseList;
    private ArrayAdapter<Course> courseArrayAdapter;
    private int selectedCoursePos = -1;
    private String studentID;
    private String studentName;
    private Button addCourseButton;
    private Button backBtn;
    private Student currentStudent;
    private List<Schedule> schedule;
    private ArrayList<Integer> courseIds;
    private ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Bundle b = getIntent().getExtras();
        if(b != null) {
            studentID = b.getString(Variables.student_ID);
            studentName = b.getString(Variables.student_Name);
            currentStudent = new Student(Integer.parseInt(studentID), studentName);
        }

        accessCourse = new AccessCourse(this);
        validatorCourse = new ValidatorCourse();
        accessSchedule = new AccessSchedule(this);
        schedule = new ArrayList<>();
        courseIds = new ArrayList<>();
        courses = new ArrayList<>();

        try {
            addCourseButton = (Button) findViewById(R.id.addCourseBtn_course);
            backBtn = findViewById(R.id.backBtn_course);
            courseList = new ArrayList<>();
            if(accessCourse.getCourseSequential().isEmpty()){
                getCourseList();
            }
            courseList.addAll(accessCourse.getCourseSequential());

            Log.i(Variables.tag, Variables.id + ": " + courseList.get(0).getCourseId() + ", " + Variables.name + ": " + courseList.get(0).getCourseName()
                    + ", " + Variables.time + ": " + courseList.get(0).getCourseTime() + ", " + Variables.day + ": " + courseList.get(0).getCourseDay());

            courseArrayAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, courseList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    text1.setText(courseList.get(position).getCourseName());
                    return view;
                }
            };

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent courseIntent = new Intent(CourseActivity.this, ScheduleActivity.class);
                    courseIntent.putExtra(Variables.student_ID, studentID);
                    courseIntent.putExtra(Variables.student_Name, studentName);
                    startActivity(courseIntent);
                }
            });

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

                        schedule = accessSchedule.getScheduleSequential(currentStudent);



                        addCourseButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                // Do something in response to button click

                                if(validatorCourse.scheduleIsEmpty(schedule)){
                                    Intent courseIntent = new Intent(CourseActivity.this, ScheduleActivity.class); //Goes to ScheduleActivity Page
                                    courseIntent.putExtra(Variables.course_ID, String.valueOf(selectedCourse.getCourseId()));
                                    courseIntent.putExtra(Variables.student_ID, studentID);
                                    courseIntent.putExtra(Variables.student_Name, studentName);
                                    startActivity(courseIntent);
                                    finish();
                                }else{
                                    Log.i(Variables.tag, "scheduleList: "+schedule);

                                    try{
                                        courseIds = accessSchedule.getCourseIDs(currentStudent);
                                        courses = accessCourse.getCourses(courseIds);

                                        if(!validatorCourse.courseAlreadyAdded(selectedCourse,courseIds)){
                                            Course clashCourse = validatorCourse.courseTimeOverlap(selectedCourse,courses);
                                            if(clashCourse == null){
                                                Intent courseIntent = new Intent(CourseActivity.this, ScheduleActivity.class); //Goes to ScheduleActivity Page
                                                courseIntent.putExtra(Variables.course_ID, String.valueOf(selectedCourse.getCourseId()));
                                                courseIntent.putExtra(Variables.student_ID, studentID);
                                                courseIntent.putExtra(Variables.student_Name, studentName);
                                                startActivity(courseIntent);
                                                finish();
                                            }else{
                                                throw new DuplicateCourseException(Message.time_Conflict + "COMP " + clashCourse.getCourseId());
                                            }
                                        }else{
                                            throw new DuplicateCourseException(Message.duplicate_Course);
                                        }
                                    }catch (DuplicateCourseException e){
                                        Toast.makeText(CourseActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                                    }

                                }//else
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

        CourseList courseList = new CourseList();
        courseList.createList(accessCourse);

        Log.i(Variables.tag, "courseList: " + accessCourse.getCourseSequential());
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
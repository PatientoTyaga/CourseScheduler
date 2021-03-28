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

import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessCourse;
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
    private String studentID;
    private String studentName;
    private String courseID;
    private String courseName;
    private String courseTime;
    private String courseDay;
    private Button addSchedule;
    private Button deleteSchedule;
    private Button loginPageBtn;
    private Button deleteCourse;
    private Button addCourse;
    private TextView studentNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Bundle b = getIntent().getExtras();
        if(b != null) {
            studentID = b.getString("studentID");
            studentName = b.getString("studentName");

            courseID = b.getString("courseID");
            courseName = b.getString("courseName");
            courseTime = b.getString("courseTime");
            courseDay = b.getString("courseDay");
            Log.i("myTag", "schedule studentID: "+studentID+", courseID: "+courseID);
        }

        Log.i("myTag", "Name: "+studentName+", ID: "+studentID);
        studentNameText = (TextView) findViewById(R.id.studentName_schedule);
        studentNameText.setText(studentName);

        try {
            accessSchedule = new AccessSchedule(this);

            if(studentID != null && courseID != null){
                Log.i("myTag", "schedule studentID: "+studentID+", courseID: "+courseID);
                int sId = Integer.parseInt(studentID);
                int cId = Integer.parseInt(courseID);
                Schedule schedule = new Schedule( sId, cId);
                accessSchedule.insertSchedule(schedule);
            }

            scheduleList = new ArrayList<>();
            currentStudent = new Student(Integer.parseInt(studentID), studentName);
            addSchedule = findViewById(R.id.addScheduleBtn_schedule);
            loginPageBtn = findViewById(R.id.backToLogin_schedule);
            deleteCourse = findViewById(R.id.deleteCourseBtn_schedule);
            deleteSchedule = findViewById(R.id.deleteScheduleBtn_schedule);
            addCourse = findViewById(R.id.addCourseBtn_schedule);

            if(!accessSchedule.getScheduleSequential(currentStudent).isEmpty()){
                addCourse.setVisibility(View.VISIBLE);
                deleteCourse.setVisibility(View.VISIBLE);
                addSchedule.setVisibility(View.INVISIBLE);
                deleteSchedule.setVisibility(View.VISIBLE);
            }
            else{
                addCourse.setVisibility(View.INVISIBLE);
                deleteCourse.setVisibility(View.INVISIBLE);
                addSchedule.setVisibility(View.VISIBLE);
                deleteSchedule.setVisibility(View.INVISIBLE);
            }

            scheduleList.addAll(accessSchedule.getScheduleSequential(currentStudent)); //adds the schedules that the currentStudent has to a list
            scheduleArrayAdapter = new ArrayAdapter<Schedule>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, scheduleList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = view.findViewById(android.R.id.text1);
                    text1.setText("COMP " + scheduleList.get(position).getCourseID());
                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.scheduleList_schedule);
            listView.setAdapter(scheduleArrayAdapter);
            //lists the schedule objects from the database
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == selectedSchedulePos) {
                        listView.setItemChecked(position, false);
                        selectedSchedulePos = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        selectedSchedulePos = position;
                        selectScheduleAtPosition(position); //calls the method to set the current student in database
                    }
                }
            });

            addCourse.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Do something in response to button click
                    Intent scheduleIntent = new Intent(ScheduleActivity.this, CourseActivity.class); //Goes to Course Page
                    scheduleIntent.putExtra("studentID", studentID);
                    scheduleIntent.putExtra("studentName", studentName);
                    startActivity(scheduleIntent);
                }
            });

            deleteSchedule.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    accessSchedule.deleteSchedule(currentStudent);
                    // Do something in response to button click
                    Intent scheduleIntent = new Intent(ScheduleActivity.this, ScheduleActivity.class); //Goes to Course Page
                    scheduleIntent.putExtra("studentID", studentID);
                    scheduleIntent.putExtra("studentName", studentName);
                    startActivity(scheduleIntent);
                }
            });

            addSchedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Updating Student");
                    if(courseID != null) {
                        Schedule newSchedule = new Schedule(Integer.parseInt(studentID), Integer.parseInt(courseID));
                        accessSchedule.insertSchedule(newSchedule);
                        Intent intent = new Intent(ScheduleActivity.this, ScheduleActivity.class); //Goes to Course Page
                        intent.putExtra("studentID", Integer.parseInt(studentID));
                        intent.putExtra("studentName", studentName);
                        startActivity(intent);
                        Toast.makeText(ScheduleActivity.this, "Schedule added successful", Toast.LENGTH_LONG).show();
                        Log.i("myTag", "Schedule added");
                    }
                    else {
                        Intent scheduleIntent = new Intent(ScheduleActivity.this, CourseActivity.class); //Goes to Course Page
                        scheduleIntent.putExtra("studentID", studentID);
                        scheduleIntent.putExtra("studentName", studentName);
                        startActivity(scheduleIntent);
                    }
                }
            });

            loginPageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent scheduleIntent = new Intent(ScheduleActivity.this, MainActivity.class); //Goes to Course Page
                    scheduleIntent.putExtra("studentID", studentID);
                    scheduleIntent.putExtra("studentName", studentName);
                    startActivity(scheduleIntent);
                }
            });

        } catch (final Exception e) {
            e.printStackTrace();
            Log.e("myTag", "Error: " + e);
        }
    }

    public void selectScheduleAtPosition(int position) {
        Schedule selected = scheduleArrayAdapter.getItem(position);
        Log.i("myTag", String.valueOf(selected.getCourseID()));

        try {
            List<String> courseList = new ArrayList<>();

            courseList.add(String.valueOf(selected.getCourseID())); //adds the schedules that the currentStudent has to a list
            ArrayAdapter<String> courseListAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text2, courseList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                    text2.setText(courseList.toString());
                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.courseList_schedule);
            listView.setAdapter(courseListAdaptor);

            deleteCourse.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //call the delete method from accessSchedule
                    accessSchedule.deleteCourse(selected);
                    Log.i("myTag", "delete schedule entry");

                    // Do something in response to button click
                    Intent scheduleIntent = new Intent(ScheduleActivity.this, ScheduleActivity.class); //Goes to Course Page
                    scheduleIntent.putExtra("studentID", studentID);
                    scheduleIntent.putExtra("studentName", studentName);
                    startActivity(scheduleIntent);
                }
            });
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}
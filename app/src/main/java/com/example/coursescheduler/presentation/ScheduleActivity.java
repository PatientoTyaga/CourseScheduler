package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coursescheduler.R;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.persistence.Database;

import java.io.Console;

public class ScheduleActivity extends AppCompatActivity {

    String fallCourseList;
    String winterCourseList;
    String Name;
    String fallCourse;
    String winterCourse;
    TextView result;
    TextView fallTextView;
    TextView winterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        fallCourseList = "";
        winterCourseList = "";

        result = (TextView)findViewById(R.id.displaySchedule);
        Name = getIntent().getExtras().getString("Name");
        if(Name != null) {
            Database.currentStudent = Name;
        }
        result.setText("Name:"+" " + Database.currentStudent);


        Log.i("myTag1", "hi: ");

        fallTextView = (TextView)findViewById(R.id.displayFallCourse);
        fallCourse = getIntent().getExtras().getString("Fall");

        winterTextView = (TextView)findViewById(R.id.displayWinterCourse);
        winterCourse = getIntent().getExtras().getString("Winter");

        try {
            for (Course c : Database.courseList) {
                if (c.getCourseId().matches(fallCourse)) {
                    Database.fallCourse.add(c);
                    for(int i=0; i<Database.fallCourse.size(); i++){
                        Log.i("myTag", "hi: " +Database.fallCourse.get(Database.fallCourse.size()-1).getCourseId() + " , " + Database.fallCourse.size());
                        fallCourseList += "" + Database.fallCourse.get(i).getCourseId() + ", \n";
                    }
                }
//                if (c.getCourseId().matches(winterCourse)) {
//                    Database.winterCourse.add(c);
//                    for(int i=0; i<Database.winterCourse.size(); i++){
//                        Log.i("myTag", "hi: " +Database.winterCourse.get(Database.winterCourse.size()-1).getCourseId() + " , " + Database.winterCourse.size());
//                        winterCourseList += "" + Database.winterCourse.get(i).getCourseId() + ", \n";
//                    }
//                }
            }
            fallTextView.setText(fallCourseList);
//            winterTextView.setText(winterCourseList);
        }
        catch (Exception e){
            System.out.println(e);
        }


        Button add = (Button)findViewById(R.id.adding);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will change the page to courseActivity.java
                Intent courseIntent = new Intent(ScheduleActivity.this, CourseActivity.class);
                startActivity(courseIntent);
            }
        });

        Button back = (Button)findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will change the page to mainActivity.java
                Intent mainIntent = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
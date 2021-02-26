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
        fallTextView = (TextView)findViewById(R.id.displayFallCourse);
        winterTextView = (TextView)findViewById(R.id.displayWinterCourse);

        Name = getIntent().getExtras().getString("Name");
        if(Name != null) {
            Database.currentStudent = Name;
        }
        result.setText("Name:"+" " + Database.currentStudent);

        try {
            for(Course c:Database.scheduleCourseList.get(0)){ //concatenates  the fall courses ID to a string
                fallCourseList += "" + c.getCourseId() + "\n";
            }
            for(Course c:Database.scheduleCourseList.get(1)){ //concatenates  the winter courses ID to a string
                winterCourseList += "" + c.getCourseId() + "\n";
            }
            Log.i("myTag", "FallCourseList: " + fallCourseList);
            Log.i("myTag", "WinterCourseList: " + winterCourseList);
            fallTextView.setText(fallCourseList); //display the fall courses inside the Fall Term TextView
            winterTextView.setText(winterCourseList); //display the winter courses inside the Winter Term TextView
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
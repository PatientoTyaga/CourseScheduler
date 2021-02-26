package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.coursescheduler.persistence.Database;
import com.example.coursescheduler.R;
import com.example.coursescheduler.objects.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private List<String> courseName = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        for(int i=0; i<Database.courseList.size(); i++){
            courseName.add(Database.courseList.get(i).getCourseId());
        }

        Spinner dropdown = findViewById(R.id.spinnerCourseName);
        Button submit = (Button) findViewById(R.id.addCourse);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courseName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dataAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will change the page to scheduleActivity.java
                String spinText = dropdown.getSelectedItem().toString();
                Intent scheduleIntent = new Intent(CourseActivity.this, ScheduleActivity.class);
                CheckBox fallTerm = (CheckBox) findViewById(R.id.checkBoxFall);
                CheckBox winterTerm = (CheckBox) findViewById(R.id.checkBoxWinter);
                if (fallTerm.isChecked()){
                    scheduleIntent.putExtra("Fall", spinText);

                    for (Course c : Database.courseList) {
                        if (c.getCourseId().matches(spinText)) {
                            Database.scheduleCourseList.get(0).add(c);
                            Log.i("myTag", "hi: Fall: " +c.getCourseId() + " , " + Database.scheduleCourseList.get(0).size());
                        }
                    }

                }
                if(winterTerm.isChecked()){
                    scheduleIntent.putExtra("Winter", spinText);
                    for (Course c : Database.courseList) {
                        if (c.getCourseId().matches(spinText)) {
                            Database.scheduleCourseList.get(1).add(c);
                            Log.i("myTag", "hi: Winter: " +c.getCourseId() + " , " + Database.scheduleCourseList.get(0).size());
                        }
                    }
                }

                startActivity(scheduleIntent);
            }
        });

    }
}
package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.coursescheduler.Database.Database;
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
        Spinner dropdown = findViewById(R.id.spinnerCourseName);
        String[][] database = Database.courseInfo.clone();
        Button submit = (Button)findViewById(R.id.buttonSchedules);

        for(int i=0; i<database.length; i++){
            Course c = new Course(database[i][0], database[i][1], database[i][2], database[i][3]);
            courseName.add(c.getCourseName());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courseName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dataAdapter);
    }

    public void buttonPreviousOnClick(View v) {
        Intent coursesIntent = new Intent(CourseActivity.this, ScheduleActivity.class);
        CourseActivity.this.startActivity(coursesIntent);
    }
}
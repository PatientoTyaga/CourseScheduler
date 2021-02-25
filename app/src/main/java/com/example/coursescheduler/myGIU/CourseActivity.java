package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.coursescheduler.Database.Database;
import com.example.coursescheduler.R;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Student;

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
        Button submit = (Button) findViewById(R.id.addCourse);

        for (int i = 0; i < database.length; i++) {
            Course c = new Course(database[i][0], database[i][1], database[i][2], database[i][3]);
            courseName.add(c.getCourseName());
        }

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
                }
                else if(winterTerm.isChecked()){
                    scheduleIntent.putExtra("Winter", spinText);
                }

                startActivity(scheduleIntent);
            }
        });

    }
}
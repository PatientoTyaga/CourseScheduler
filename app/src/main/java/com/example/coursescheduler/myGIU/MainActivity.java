package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.coursescheduler.objects.Student;

import com.example.coursescheduler.R;

public class MainActivity extends AppCompatActivity {

    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dropdown = findViewById(R.id.spinner1);


        try {
            Student s1 = new Student("7784215", "Simrandeep");
            Student s2 = new Student("1234567", "John");
            studentList = new ArrayList<>();
            studentList.add(s1);
            studentList.add(s2);
            String[] items = new String[]{s1.getStudentName(), s2.getStudentName()};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
            dropdown.setAdapter(adapter);

        }
        catch (final Exception e){
            System.out.println(e);
        }
    }

    public void buttonScheduleOnClick(View v) {
        Intent coursesIntent = new Intent(MainActivity.this, CourseActivity.class);
        MainActivity.this.startActivity(coursesIntent);
    }

}
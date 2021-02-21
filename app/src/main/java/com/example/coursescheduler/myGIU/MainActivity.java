package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.*;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.Database.Database;
import com.example.coursescheduler.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dropdown = findViewById(R.id.spinnerStudentName);
        String[][] database = Database.studentInfo.clone();
        Student s1 = new Student(database[0][1], database[0][0]);
        Student s2 = new Student(database[1][1], database[1][0]);
        Student s3 = new Student(database[2][1], database[2][0]);
        Button submit = (Button)findViewById(R.id.buttonSchedules);
        try {

            studentList = new ArrayList<>();
            studentList.add(s1);
            studentList.add(s2);
            studentList.add(s3);
            String[] items = new String[]{s1.getStudentName(), s2.getStudentName(), s3.getStudentName()};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
            dropdown.setAdapter(adapter);

        } catch (final Exception e) {
            System.out.println(e);
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will change the page to scheduleActivity.java
                String spinText = dropdown.getSelectedItem().toString();
                Intent scheduleIntent = new Intent(MainActivity.this, ScheduleActivity.class);
                scheduleIntent.putExtra("Name", spinText);
                startActivity(scheduleIntent);
            }
        });
    }

    @Override
    public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){

    }

    @Override
    public void onNothingSelected (AdapterView < ? > parent){

    }
}
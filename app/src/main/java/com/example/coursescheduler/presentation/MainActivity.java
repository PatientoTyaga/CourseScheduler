package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.*;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.Database;
import com.example.coursescheduler.R;

public class MainActivity extends AppCompatActivity {

    private List<String> studentName = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database.initData(); //initialize the database and initializes up the ArrayList list in Database

        for(int i=0; i<Database.studentList.size(); i++){
            studentName.add(Database.studentList.get(i).getStudentName()); //populates the studentName list with the elements in ArrayList from database
        }

        Spinner dropdown = findViewById(R.id.spinnerStudentName); //dropdown menu for students
        Button submit = (Button)findViewById(R.id.buttonSchedules); //button to open schedule once student is selected

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, studentName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dataAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will change the page to scheduleActivity.java
                String spinText = dropdown.getSelectedItem().toString();
                Intent scheduleIntent = new Intent(MainActivity.this, ScheduleActivity.class); //Goes to ScheduleActivity Page
                for(int i=0; i<Database.studentList.size(); i++){
                    if (Database.studentList.get(i).getStudentName().matches(spinText)){
                        scheduleIntent.putExtra("Name", Database.studentList.get(i).getStudentName());
                    }
                }
                 //sends the student name as a parameter to the scheduleActivity Page
                startActivity(scheduleIntent);
            }
        });
    }
}
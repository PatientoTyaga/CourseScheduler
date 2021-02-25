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

public class MainActivity extends AppCompatActivity {

    private List<String> studentName = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dropdown = findViewById(R.id.spinnerStudentName);
        String[][] database = Database.studentInfo.clone();
        Button submit = (Button)findViewById(R.id.buttonSchedules);

        for(int i=0; i<database.length; i++){
            Student s = new Student(database[i][1], database[i][0]);
            studentName.add(s.getStudentName());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, studentName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dataAdapter);

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
}
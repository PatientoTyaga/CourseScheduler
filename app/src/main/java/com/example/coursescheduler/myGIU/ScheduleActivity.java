package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coursescheduler.R;

public class ScheduleActivity extends AppCompatActivity {

    String Name;
    TextView result;
    TextView theFall;
    TextView theWinter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        result = (TextView)findViewById(R.id.displaySchedule);
        Name = getIntent().getExtras().getString("Name");
        result.setText("Name:"+" " + Name);
        theFall = (TextView)findViewById(R.id.fall);
        theFall.setText("Fall: ");
        theWinter = (TextView)findViewById(R.id.winter);
        theWinter.setText("Winter: ");
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
package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.coursescheduler.R;

public class ScheduleActivity extends AppCompatActivity {

    String Name;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        result = (TextView)findViewById(R.id.displaySchedule);
        Name = getIntent().getExtras().getString("Name");
        result.setText("Name: " + Name);
    }
}
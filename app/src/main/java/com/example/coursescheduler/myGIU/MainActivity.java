package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.coursescheduler.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonScheduleOnClick(View v) {
        Intent coursesIntent = new Intent(MainActivity.this, CourseActivity.class);
        MainActivity.this.startActivity(coursesIntent);
    }

}
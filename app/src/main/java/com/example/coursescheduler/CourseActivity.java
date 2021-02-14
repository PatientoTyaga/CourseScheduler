package com.example.coursescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }

    public void buttonPreviousOnClick(View v) {
        Intent coursesIntent = new Intent(CourseActivity.this, MainActivity.class);
        CourseActivity.this.startActivity(coursesIntent);
    }
}
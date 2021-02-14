package com.example.coursescheduler.myGIU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.coursescheduler.R;

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
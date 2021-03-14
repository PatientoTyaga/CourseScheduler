package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.R;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AccessStudent accessStudent;
    private List<Student> studentList;
    private ArrayAdapter<Student> studentArrayAdapter;

    private int selectedStudentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Database.initData(); //initialize the database and initializes up the ArrayList list in Database
        accessStudent = new AccessStudent(this);

        try {
            studentList = new ArrayList<>();
            studentList.addAll(accessStudent.getStudentSequential());
            Log.i("myTag", studentList.get(0).getStudentName());
            studentArrayAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, studentList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    text1.setText(studentList.get(position).getStudentName());
                    return view;
                }
            };

            final ListView listView = (ListView) findViewById(R.id.listViewStudent);
            listView.setAdapter(studentArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == selectedStudentPos) {
                        listView.setItemChecked(position, false);
                        selectedStudentPos = -1;
                    } else {
                        listView.setItemChecked(position, true);
                        selectedStudentPos = position;
//                        selectStudentAtPosition(position); //calls the method to set the current student in database
//                        Intent scheduleIntent = new Intent(MainActivity.this, ScheduleActivity.class); //Goes to ScheduleActivity Page
//                        startActivity(scheduleIntent);
                    }
                }
            });
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

//    public void selectStudentAtPosition(int position) {
//        Student selected = studentArrayAdapter.getItem(position);
//        accessStudent.setCurrentStudent(selected);
//
//        TextView studentID = (TextView)findViewById(R.id.textStudentID);
//        TextView studentName = (TextView)findViewById(R.id.textStudentName);
//
//        studentID.setText("Student ID: "+ selected.getStudentName());
//        studentName.setText("Student Name: "+ selected.getStudentID());
//    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
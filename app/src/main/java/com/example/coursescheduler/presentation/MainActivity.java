package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.business.Validator;
import com.example.coursescheduler.objects.Student;

public class MainActivity extends AppCompatActivity {

    private Button schedule;
    private Button delete;
    private Button update;
    private Button logout;
    private Button edit;
    private Button back;
    private AccessStudent accessStudent;
    private Validator validator;
    private Student currentStudent;
    private String studentID;
    private String studentName;
    private EditText editName;
    private TextView studentIdText;
    private TextView studentNameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        if(b != null) {
            studentID = b.getString("studentID");
            studentName = b.getString("studentName");
        }

        accessStudent = new AccessStudent(this);
        validator = new Validator();
        currentStudent = new Student(Integer.parseInt(studentID), studentName);

        try{
            studentIdText = (TextView) findViewById(R.id.studentID_main);
            studentNameText = (TextView) findViewById(R.id.studentName_main);
            studentNameText.setText(studentName);
            studentIdText.setText(studentID);

            delete = findViewById(R.id.deleteBtn_main);
            update = findViewById(R.id.updateBtn_main);
            back = findViewById(R.id.backBtn_main);
            schedule = findViewById(R.id.scheduleBtn_main);
            logout = findViewById(R.id.logoutBtn_main);
            edit = findViewById(R.id.editBtn_main);
            editName = findViewById(R.id.studentName_editText_main);

            delete.setVisibility(View.INVISIBLE);
            update.setVisibility(View.INVISIBLE);
            editName.setVisibility(View.INVISIBLE);
            back.setVisibility(View.INVISIBLE);

            schedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent scheduleIntent = new Intent(MainActivity.this, ScheduleActivity.class);
                    scheduleIntent.putExtra("studentID", studentID);
                    scheduleIntent.putExtra("studentName", studentName);
                    startActivity(scheduleIntent);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Deleting Student");
                    deleteStudent();
                }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Updating Student");
                    updateStudent(editName);
                }
            });

            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Logout Student");
                    logoutStudent();
                    Toast.makeText(MainActivity.this, "Logout successful", Toast.LENGTH_LONG).show();
                    Log.i("myTag", "Student logged out");
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Deleting Student");
                    Toast.makeText(MainActivity.this, "WARNING!! PLEASE KNOW ANY UPDATE IS FINAL. PLEASE SAVE YOUR NEW NAME SOMEWHERE BEFORE CONFIRMING UPDATE", Toast.LENGTH_LONG).show();
                    editStudent();
                }
            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Back to Main Page with no changes to Student");
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.putExtra("studentID", studentID);
                    intent.putExtra("studentName", studentName);
                    Toast.makeText(MainActivity.this, "No edit made", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            });

        } catch (Exception e){
            e.printStackTrace();
            Log.e("myTag", "Error: " + e);
            throw e;
        }
    }

    protected void deleteStudent(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        Toast.makeText(MainActivity.this, "Delete successful", Toast.LENGTH_LONG).show();
        Log.i("myTag", "Starting Delete function");
        accessStudent.deleteStudent(currentStudent);
        Log.i("myTag", "Delete successful");
        startActivity(intent);
        finish();
    }

    protected void editStudent(){
        delete.setVisibility(View.VISIBLE);
        update.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        edit.setVisibility(View.INVISIBLE);
        editName.setVisibility(View.VISIBLE);
        studentIdText.setVisibility(View.INVISIBLE);
        studentNameText.setVisibility(View.INVISIBLE);
        logout.setVisibility(View.INVISIBLE);
        schedule.setVisibility(View.INVISIBLE);

    }

    protected void logoutStudent(){

        //make sure upon logout, user cant access profile again unless they sign in again

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    protected void updateStudent(EditText studentName) {

        if(validator.validateStudentUpdate(studentName)){
            Toast.makeText(MainActivity.this, "Update Successful. Please login with new credentials", Toast.LENGTH_LONG).show();
            Log.i("myTag", "Starting Update function");
            Student newStudent = new Student(currentStudent.getStudentID(), studentName.getText().toString());
            accessStudent.updateStudent(newStudent);
            Log.i("myTag", "Update successful");
            Toast.makeText(MainActivity.this, "Update successful", Toast.LENGTH_LONG).show();
            logoutStudent();
        }

    }
}
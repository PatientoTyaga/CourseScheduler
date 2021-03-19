package com.example.coursescheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.objects.Student;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private AccessStudent accessStudents;
    private List<Student> studentList;
    private Student currentStudent;
    private EditText studentID;
    private EditText studentName;
    private Button registerStudentBtn;
    private Button loginStudentBtn;
    private String msg;
    private boolean match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accessStudents = new AccessStudent(this);
        try {
            studentList = new ArrayList<>();
            studentList.addAll(accessStudents.getStudentSequential());
            studentID = findViewById(R.id.studentID_login);
            studentName = findViewById(R.id.studentName_login);
            registerStudentBtn = findViewById(R.id.registerBtn_login);
            loginStudentBtn = findViewById(R.id.loginBtn_login);

            registerStudentBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    registerStudent();
                }
            });

            loginStudentBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(studentID.getText().toString() != null && studentName.toString() != null){
                        loginStudent();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerStudent(){
        // Goes to Student Register form on register button click
        Intent scheduleIntent = new Intent(LoginActivity.this, RegisterActivity.class); //Goes to ScheduleActivity Page
        startActivity(scheduleIntent);
    }

    protected boolean validate(){
        for(Student s: studentList){
            Log.i("myTag", s.getStudentName() + ", " + s.getStudentID());
            if(s.getStudentID() == Integer.parseInt(studentID.getText().toString()) && s.getStudentName().matches(studentName.getText().toString())){
                Log.i("myTag", s.getStudentName() + " reached");
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }

    public void loginStudent(){
        // checks for the student inside the list of students from database
        if(validate()){
            Log.i("myTag", "login function reached");
            Student student = new Student(Integer.parseInt(studentID.getText().toString()), studentName.getText().toString());
            currentStudent = accessStudents.fetchStudent(student);

            msg = "Redirecting to Main Page!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            Intent scheduleIntent = new Intent(this, MainActivity.class); //Goes to ScheduleActivity Page
            scheduleIntent.putExtra("studentID", studentID.getText().toString());
            scheduleIntent.putExtra("studentName", studentName.getText().toString());
            studentID.setText("");
            studentName.setText("");
            startActivity(scheduleIntent);
        }
        else if(!validate()){
            msg = "User not found, please check credentials or register";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            studentID.setText("");
            studentName.setText("");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

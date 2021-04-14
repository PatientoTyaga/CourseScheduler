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
import com.example.coursescheduler.Variables;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.business.Validator;
import com.example.coursescheduler.business.exceptions.StudentNotFoundException;
import com.example.coursescheduler.objects.Student;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private AccessStudent accessStudents;
    private Validator validator;
    private List<Student> studentList;
    private EditText studentID;
    private EditText studentName;
    private Button registerStudentBtn;
    private Button loginStudentBtn;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accessStudents = new AccessStudent(this);
        validator = new Validator();
        try {
            studentList = new ArrayList<>();
            studentList.addAll(accessStudents.getStudentSequential());
            Log.i(Variables.tag, "studentList: "+studentList);
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
                    else{
                        Log.i(Variables.tag, Variables.id + ": " + studentID.getText().toString() + ", " + Variables.name + ": " + studentName.toString());
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
        finish();
    }


    public void loginStudent(){
        if(validator.validateNameAndIdEntry(studentName,studentID)){
            // checks for the student inside the list of students from database
            boolean accountExists = validator.accountExists(studentList,studentID);

            try{
                if(accountExists){
                    //check if account with given id exists
                    Student student = new Student(Integer.parseInt(studentID.getText().toString()), studentName.getText().toString());
                    Student currentStudent = accessStudents.fetchStudent(student);
                    boolean studentExists = validator.validateStudent(this,currentStudent,studentName);
                    if(studentExists){
                        //check if name matches name connected to account with given id
                        Log.i(Variables.tag, "login function reached");

                        msg = "Redirecting to Main Page!";
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                        Intent scheduleIntent = new Intent(this, MainActivity.class); //Goes to ScheduleActivity Page
                        scheduleIntent.putExtra(Variables.student_ID, studentID.getText().toString());
                        scheduleIntent.putExtra(Variables.student_Name, studentName.getText().toString());
                        studentID.setText("");
                        studentName.setText("");
                        startActivity(scheduleIntent);
                        finish();
                    }
                }else{
                    throw new StudentNotFoundException();
                }
            }catch (StudentNotFoundException e){
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

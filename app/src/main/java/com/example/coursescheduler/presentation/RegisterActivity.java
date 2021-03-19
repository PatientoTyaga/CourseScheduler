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

public class RegisterActivity extends AppCompatActivity {

    private EditText studentName;
    private EditText studentID;
    private Button register;
    private Button login;
    private List<Student> studentList;
    private AccessStudent accessStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        accessStudents = new AccessStudent(this);

        try {
            studentList = new ArrayList<>();
            studentList.addAll(accessStudents.getStudentSequential());

            studentName = findViewById(R.id.studentName_register);
            studentID = findViewById(R.id.studentID_register);
            register = findViewById(R.id.registerBtn_register);
            login = findViewById(R.id.loginBtn_register);

            String inputName = studentName.getText().toString();
            String inputID = studentID.getText().toString();

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inputName == null || inputID == null) {
                        Toast.makeText(RegisterActivity.this, "Please enter both student name and ID", Toast.LENGTH_LONG).show();
                    } else {
                        if (!accountExists()) {
                            Log.i("myTag", "creating account");
                            createAccount();
                            Log.i("myTag", "account created");
                            Toast.makeText(RegisterActivity.this, "Account created successfully", Toast.LENGTH_LONG).show();
                            login();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Account already exists", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void login() {
        //to Login activity
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private boolean accountExists() {
        // add loop to check the input name match the database name
        boolean valid = false;
        for(Student s: studentList){
            Log.i("myTag", s.getStudentName() + ", " + s.getStudentID());
            if(s.getStudentID() == Integer.parseInt(studentID.getText().toString())){
                valid = true;
                break;
            }
            else{
                valid = false;
            }
        }
        return valid;
    }

    protected void createAccount(){
        Log.i("myTag", "inside method createAccount");
        Student student = new Student(Integer.parseInt(studentID.getText().toString()), studentName.getText().toString());
        Log.i("myTag", student.getStudentName() + ", " + student.getStudentID());
        accessStudents.insertStudent(student);
        Log.i("myTag", "account created");
    }
}

//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String inputName = studentName.getText().toString();
//                String inputID = studentID.getText().toString();
//                if(inputName.isEmpty() || inputID.isEmpty()){
//                    Toast.makeText(RegisterActivity.this,"Please enter all detail",Toast.LENGTH_LONG).show();
//                }
//                else{
//                    if(!validate(inputName,inputID)){
//                        Toast.makeText(RegisterActivity.this,"Please registor first",Toast.LENGTH_LONG).show();
//                    }
//                    else{
//                        Toast.makeText(RegisterActivity.this,"Login successful",Toast.LENGTH_LONG).show();
//                        //to main activity
//                        Intent intent= new Intent(RegisterActivity.this, MainActivity.class);
//                        startActivity(intent);
//                    }
//                }
//            }
//        });
//    }
//}
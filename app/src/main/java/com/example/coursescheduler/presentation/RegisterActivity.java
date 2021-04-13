package com.example.coursescheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursescheduler.Message;
import com.example.coursescheduler.R;
import com.example.coursescheduler.Variables;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.business.Validator;
import com.example.coursescheduler.business.exceptions.ExistingAccountException;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private Validator validator;
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
        validator = new Validator();

        try {
            studentList = new ArrayList<>();
            studentList.addAll(accessStudents.getStudentSequential());

            studentName = findViewById(R.id.studentName_register);
            studentID = findViewById(R.id.studentID_register);
            register = findViewById(R.id.registerBtn_register);
            login = findViewById(R.id.loginBtn_register);




            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(validator.validateNameAndIdEntry(studentName,studentID)) {

                        try{
                            if(!accountExists(studentList, studentID)) {
                                Log.i(Variables.tag, Message.create_Account);
                                createAccount();
                                Log.i(Variables.tag, Message.account_Success);
                                Toast.makeText(RegisterActivity.this, Message.account_Success, Toast.LENGTH_LONG).show();
                                login();
                            }else {
                                throw new ExistingAccountException();
                            }
                        }catch (ExistingAccountException e){
                            Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
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
        finish();
    }

    private boolean accountExists(List<Student> students, EditText studentID) {
        // add loop to check the input name match the database name
        return(validator.accountExists(students,studentID));
    }


    protected void createAccount(){
        Log.i(Variables.tag, "inside method createAccount");
        Student student = new Student(Integer.parseInt(studentID.getText().toString()), studentName.getText().toString());
        Log.i(Variables.tag, student.getStudentName() + ", " + student.getStudentID());
        accessStudents.insertStudent(student);
        Log.i(Variables.tag, Message.account_Success);
    }
}
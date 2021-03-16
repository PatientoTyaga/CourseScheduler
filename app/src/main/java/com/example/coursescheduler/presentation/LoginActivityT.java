package com.example.coursescheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursescheduler.R;
import com.example.coursescheduler.database.DatabaseHelper;

public class LoginActivityT extends AppCompatActivity {
    private EditText studentName;
    private EditText studentID;
    private Button Login;
    private Button registor;
    private TextView instructor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logint);
        studentName=(EditText) findViewById(R.id.studentName);
        studentID=(EditText) findViewById(R.id.studentID);
        Login=(Button) findViewById(R.id.Login);
        registor=(Button) findViewById(R.id.Load);
        instructor= findViewById(R.id.instruction);
        instructor.setText("no account click here");
        registor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to Login activity
                Intent intent= new Intent(LoginActivityT.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = studentName.getText().toString();
                String inputID = studentID.getText().toString();
                if(inputName.isEmpty() || inputID.isEmpty()){
                    Toast.makeText(LoginActivityT.this,"Please enter all detail",Toast.LENGTH_LONG).show();
                }
                else{
                    if(!validate(inputName,inputID)){
                        Toast.makeText(LoginActivityT.this,"Please registor first",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(LoginActivityT.this,"Login successful",Toast.LENGTH_LONG).show();
                        //to main activity
                        Intent intent= new Intent(LoginActivityT.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String name, String id){
        // add loop to check the input name match the database name ???
        if(name.equals() && id.equals()){
            return true;
        }
        return false;
    }
}
package com.example.coursescheduler.business.exceptions;

import android.widget.EditText;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(){
        super("Student not found: Please Enter A Valid Student Name and Valid Student ID. If You Don't Have An Account, Please Register, Then Try Again.");
    }

    public StudentNotFoundException(String message){
        super(message);
    }

}

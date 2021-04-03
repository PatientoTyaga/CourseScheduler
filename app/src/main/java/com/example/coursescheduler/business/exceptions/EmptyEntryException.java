package com.example.coursescheduler.business.exceptions;

import android.widget.EditText;

public class EmptyEntryException extends Exception{
    public EmptyEntryException(EditText studentID, EditText studentName) {
        studentID.setError("StudentID Cannot Be Empty. Please Enter A Valid StudentID.");
        studentName.setError("Student Name Cannot Be Empty. Please Enter A Valid Student Name.");
    }

    public EmptyEntryException(EditText editText, String identifier) {
        if(identifier.equals("studentIdIF")){
            editText.setError("StudentID Cannot Be Empty. Please Enter A Valid StudentID.");
        }else if(identifier.equals("studentNameIF")){
            editText.setError("Student Name Cannot Be Empty. Please Enter A Valid Student Name.");
        }
    }

    public EmptyEntryException(String message) {
        super(message);
    }
}

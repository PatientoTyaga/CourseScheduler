package com.example.coursescheduler.business.exceptions;

import android.widget.EditText;

public class IncorrectEntryFormatException extends Exception{

    /*
    public IncorrectEntryFormatException(EditText studentID, EditText studentName) {
        studentName.setError("Please Enter First Name Only With No Spaces. Letters Should Be a-z. Can Be Capital, Small, Or Both");
        studentID.setError("Please Enter A Valid StudentID Containing Positive Numbers only. Student ID Should Be Of Length 7)");
    }

     */
    /*

    public IncorrectEntryFormatException(EditText editText, String identifier) {
        if(identifier.equals("studentIdIF")){
            editText.setError("Please Enter A Student Number Containing Positive Numbers Only. The Student Number Should Be Of" +
                    "Length 7");
        }else if(identifier.equals("studentNameIF")){
            editText.setError("Please Enter First Name Only. Name Should Be Letters a-z Only.(Can Be In Captital, Small Or Both");
        }

    }

     */

    public IncorrectEntryFormatException(String message) {
        super(message);
    }
}

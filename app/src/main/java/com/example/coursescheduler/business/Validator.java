package com.example.coursescheduler.business;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coursescheduler.Message;
import com.example.coursescheduler.Variables;
import com.example.coursescheduler.business.exceptions.EmptyEntryException;
import com.example.coursescheduler.business.exceptions.IncorrectEntryFormatException;
import com.example.coursescheduler.business.exceptions.StudentNotFoundException;
import com.example.coursescheduler.objects.Student;

import java.util.List;

public class Validator {
    /*this class is for making sure that the user inputs the correct name which should be first
    name only with no spaces and only letters a-z. and making sure that id is of length 7 and consists only of integers, no characters
    if any of the above conditions are violated, an exception will be thrown
     */


    public boolean validateNameAndIdEntry(EditText studentName, EditText studentID){

        boolean toRet = false;
        boolean nameFieldIsEmpty = entryFieldIsEmpty(studentName, Variables.student_Name);
        boolean idFieldIsEmpty = entryFieldIsEmpty(studentID, Variables.student_ID);
        boolean nameEnteredCorrectly = false;
        boolean idEnteredCorrectly = false;

        if(!nameFieldIsEmpty && !idFieldIsEmpty){
            idEnteredCorrectly = correctEntry(studentID, Variables.student_ID); //check if the id field has correct input
            nameEnteredCorrectly = correctEntry(studentName, Variables.student_Name); //check if name field has correct input

            if(nameEnteredCorrectly && idEnteredCorrectly){
                toRet = true;
            }
        }
        return toRet;
    }

    public boolean entryFieldIsEmpty(EditText editText, String identifier){
        boolean toRet = false;

        try{
            if(identifier.equals(Variables.student_Name)){
                if(editText.getText().toString().isEmpty()){
                    toRet = true;
                    throw new EmptyEntryException(Message.student_Name_Empty);
                }
            }else if(identifier.equals(Variables.student_ID)){
                if(editText.getText().toString().isEmpty()){
                    toRet = true;
                    throw new EmptyEntryException(Message.student_ID_Empty);
                }
            }
        }catch (EmptyEntryException e){
            editText.setError(e.getMessage());
        }
        return toRet;
    }


    public boolean correctEntry(EditText editText, String identifier) {
        //checks if ID or Name is of the correct format

        boolean toRet = false;

        try {
            if(identifier.equals(Variables.student_ID)){
                if(!editText.getText().toString().matches("^[0-9]{7}")){
                    throw new IncorrectEntryFormatException(Message.student_ID_Incorrect);
                }else{
                    toRet = true;
                }
            }else if(identifier.equals(Variables.student_Name)){
                if(!editText.getText().toString().matches("^[a-zA-Z]*$")){
                    throw new IncorrectEntryFormatException(Message.student_Name_Incorrect);
                }else{
                    toRet = true;
                }
            }

        } catch (IncorrectEntryFormatException e) {
            editText.setError(e.getMessage());
        }

        return toRet;
    }

    public boolean validateStudent(Context context, Student student, EditText studentName){
        boolean toRet = false;

        try{
            if(!student.getStudentName().equals(studentName.getText().toString()))     {
                throw new StudentNotFoundException();
            }else{
                toRet = true;
            }
        }catch (StudentNotFoundException e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
        }

        return toRet;
    }

    public boolean validateStudentUpdate(EditText studentName){
        boolean toRet = false;
        boolean studentFieldIsEmpty = entryFieldIsEmpty(studentName, Variables.student_Name);
        boolean correctEntry = correctEntry(studentName, Variables.student_Name);
        if(!studentFieldIsEmpty && correctEntry){
            toRet = true;
        }
        return toRet;
    }

    public boolean accountExists(List<Student> students, EditText studentID) {
        // add loop to check the input name match the database name

        boolean valid = false;

        for(Student s: students){
            Log.i(Variables.tag, s.getStudentName() + ", " + s.getStudentID());
            if(s.getStudentID() == Integer.parseInt(studentID.getText().toString())){
                valid = true;
                break;
            }
        }
        return valid;
    }


}

package com.example.coursescheduler.business;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

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

    private AccessStudent accessStudents;


    public boolean validateNameAndIdEntry(EditText studentName, EditText studentID){

        boolean toRet = false;
        boolean nameFieldIsEmpty = entryFieldIsEmpty(studentName,"studentName");
        boolean idFieldIsEmpty = entryFieldIsEmpty(studentID,"studentID");
        boolean nameEnteredCorrectly = false;
        boolean idEnteredCorrectly = false;

        if(!nameFieldIsEmpty && !idFieldIsEmpty){
            idEnteredCorrectly = correctEntry(studentID,"studentId"); //check if the id field has correct input
            nameEnteredCorrectly = correctEntry(studentName, "studentName"); //check if name field has correct input

            if(nameEnteredCorrectly && idEnteredCorrectly){
                toRet = true;
            }
        }
        /*
        boolean nameEnteredCorrectly = false;
        boolean idEnteredCorrectly = false;
        EditText editText = null;


        try{
            if(studentID.getText().toString().trim().isEmpty() && studentName.getText().toString().trim().isEmpty()){
                //both entries are empty
                throw new EmptyEntryException(studentID, studentName);

            }else if(!studentID.getText().toString().trim().isEmpty() && studentName.getText().toString().trim().isEmpty()){
                //studentID field is only one that is not empty

                editText = studentName;
                idEnteredCorrectly = correctEntry(studentID,"studentIdIF"); //check if the id field has correct input
                throw new EmptyEntryException("Student Name Cannot Be Empty. Please Enter A Valid Student Name.");

            }else if(studentID.getText().toString().trim().isEmpty() && !studentName.getText().toString().trim().isEmpty()){
                //studentName field is the only one that is empty

                editText = studentID;
                nameEnteredCorrectly = correctEntry(studentName, "studentNameIF"); //check if name field has correct input
                throw new EmptyEntryException("StudentID Cannot Be Empty. Please Enter A Valid StudentID.");

            }else{
                //none of the entries are empty
                idEnteredCorrectly = correctEntry(studentID,"studentIdIF"); //check if the id field has correct input
                nameEnteredCorrectly = correctEntry(studentName, "studentNameIF"); //check if name field has correct input

                if(nameEnteredCorrectly && idEnteredCorrectly){
                    toRet = true;
                }
            }

        } catch (EmptyEntryException e) {
            editText.setError(e.getMessage());
        }

         */

        return toRet;
    }

    public boolean entryFieldIsEmpty(EditText editText, String identifier){
        boolean toRet = false;

        try{
            if(identifier.equals("studentName")){
                if(editText.getText().toString().isEmpty()){
                    toRet = true;
                    throw new EmptyEntryException("Student Name Cannot Be Empty. Please Enter A Valid Student Name.");
                }
            }else if(identifier.equals("studentID")){
                if(editText.getText().toString().isEmpty()){
                    toRet = true;
                    throw new EmptyEntryException("StudentID Cannot Be Empty. Please Enter A Valid StudentID.");
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
            if(identifier.equals("studentId")){
                if(!editText.getText().toString().matches("^[0-9]{7}")){
                    throw new IncorrectEntryFormatException("Please Enter A Student Number Containing Positive Numbers Only. The Student Number Should Be Of" +
                            "Length 7");
                }else{
                    toRet = true;
                }
            }else if(identifier.equals("studentName")){
                if(!editText.getText().toString().matches("^[a-zA-Z]*$")){
                    throw new IncorrectEntryFormatException("Please Enter First Name Only. Name Should Be Letters a-z Only.(Can Be In Captital, Small Or Both");
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
        try {
                if(studentName.getText().toString().trim().isEmpty()) {
                    throw new EmptyEntryException("StudentID Cannot Be Empty. Please Enter A Valid StudentID.");
                }else if(!correctEntry(studentName,"studentNameIF")){
                }else{
                    toRet = true;
                }
            }catch(EmptyEntryException e){
                studentName.setError(e.getMessage());
            }
        return toRet;
    }

    public boolean accountExists(List<Student> students, EditText studentID) {
        // add loop to check the input name match the database name

        boolean valid = false;

        for(Student s: students){
            Log.i("myTag", s.getStudentName() + ", " + s.getStudentID());
            if(s.getStudentID() == Integer.parseInt(studentID.getText().toString())){
                valid = true;
                break;
            }
        }

        return valid;
    }

}

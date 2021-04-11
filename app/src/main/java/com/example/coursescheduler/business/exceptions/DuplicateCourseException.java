package com.example.coursescheduler.business.exceptions;

public class DuplicateCourseException extends Exception{
    public DuplicateCourseException(){
        super("Sorry, This Course Time Clashes With An Already Existing Course In Your Schedule");
    }

    public DuplicateCourseException(String message){
        super(message);
    }
}

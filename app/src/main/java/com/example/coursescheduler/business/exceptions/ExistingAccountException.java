package com.example.coursescheduler.business.exceptions;

public class ExistingAccountException extends Exception{

    public ExistingAccountException(){
        super("Sorry, An Account With The Provided Student ID Already Exists. Please Try Log In or Try Registering With A Different ID");
    }

    public ExistingAccountException(String message){
        super(message);
    }
}

package com.example.coursescheduler.business.exceptions;

import android.widget.EditText;

public class EmptyEntryException extends Exception{
    public EmptyEntryException(String message) {
        super(message);
    }
}

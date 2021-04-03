package com.example.coursescheduler.business.exceptions;

import android.widget.EditText;

public class IncorrectEntryFormatException extends Exception{
    public IncorrectEntryFormatException(String message) {
        super(message);
    }
}

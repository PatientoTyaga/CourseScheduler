package com.example.coursescheduler.persistence.hsqldb;

import android.database.sqlite.SQLiteDatabase;

public class PersistenceException extends RuntimeException {

    public PersistenceException(final Exception cause) {
        super(cause);
    }
}


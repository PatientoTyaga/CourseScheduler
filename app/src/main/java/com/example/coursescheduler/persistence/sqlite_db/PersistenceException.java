package com.example.coursescheduler.persistence.sqlite_db;

public class PersistenceException extends RuntimeException {

    public PersistenceException(final Exception cause) {
        super(cause);
    }
}


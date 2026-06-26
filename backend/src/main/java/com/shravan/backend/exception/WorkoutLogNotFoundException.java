package com.shravan.backend.exception;

public class WorkoutLogNotFoundException
        extends RuntimeException {

    public WorkoutLogNotFoundException(
            String message
    ) {
        super(message);
    }
}
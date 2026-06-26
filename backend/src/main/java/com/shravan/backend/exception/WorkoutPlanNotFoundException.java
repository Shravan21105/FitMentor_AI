package com.shravan.backend.exception;

public class WorkoutPlanNotFoundException
        extends RuntimeException {

    public WorkoutPlanNotFoundException(
            String message
    ) {
        super(message);
    }
}
package com.shravan.backend.exception;

public class DietPlanNotFoundException
        extends RuntimeException {

    public DietPlanNotFoundException(
            String message
    ) {
        super(message);
    }
}
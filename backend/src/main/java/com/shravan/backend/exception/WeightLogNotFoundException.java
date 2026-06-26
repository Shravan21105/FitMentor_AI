package com.shravan.backend.exception;

public class WeightLogNotFoundException
        extends RuntimeException {

    public WeightLogNotFoundException(
            String message
    ) {
        super(message);
    }
}
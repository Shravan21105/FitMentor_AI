package com.shravan.backend.exception;

public class WaterLogNotFoundException
        extends RuntimeException {

    public WaterLogNotFoundException(
            String message
    ) {
        super(message);
    }
}
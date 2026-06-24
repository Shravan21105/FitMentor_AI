package com.shravan.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class WeightLogRequest {

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be positive")
    private Double weight;

    private String notes;
}
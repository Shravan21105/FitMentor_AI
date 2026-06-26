package com.shravan.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WaterRequest {

    @NotNull(message = "Water amount is required")
    @Min(value = 50, message = "Minimum water amount is 50 ml")
    private Integer amount;
}
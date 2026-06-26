package com.shravan.backend.dto;

import com.shravan.backend.entity.MealType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MealLogRequest {

    @NotNull
    private MealType mealType;

    @NotBlank
    private String foodName;

    @NotNull
    private Double quantity;

    @NotBlank
    private String unit;

    @NotNull
    private Double calories;

    @NotNull
    private Double protein;

    @NotNull
    private Double carbs;

    @NotNull
    private Double fat;
}
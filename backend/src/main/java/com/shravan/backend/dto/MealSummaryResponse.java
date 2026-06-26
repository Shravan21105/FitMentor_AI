package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealSummaryResponse {

    private Double todayCalories;

    private Double targetCalories;

    private Double remainingCalories;

    private Double protein;

    private Double carbs;

    private Double fat;
}
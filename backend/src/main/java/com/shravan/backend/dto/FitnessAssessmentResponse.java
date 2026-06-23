package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FitnessAssessmentResponse {

    private Double bmi;

    private String bmiCategory;

    private Double bmr;

    private Double dailyCalories;
}
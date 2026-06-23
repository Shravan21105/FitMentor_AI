package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    private Double startingWeight;

    private Double currentWeight;

    private Double targetWeight;

    private Double weightLost;

    private Double remainingWeight;

    private Double goalCompletionPercentage;

    private Integer currentStreak;

    private Integer totalWorkoutsCompleted;

    private Double bmi;

    private Double dailyCalories;
}
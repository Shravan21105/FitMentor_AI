package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    // User
    private String name;

    // Weight
    private Double startingWeight;
    private Double currentWeight;
    private Double targetWeight;
    private Double weightLost;
    private Double remainingWeight;
    private Double goalCompletionPercentage;

    // Workout
    private Integer currentStreak;
    private Integer totalWorkoutsCompleted;

    // Health
    private Double bmi;
    private Double dailyCalories;

    // Water
    private Integer todayWater;
    private Integer dailyWaterGoal;
    private Double waterProgress;

    // Meal
    private Double todayCalories;
    private Double remainingCalories;
    private Double todayProtein;
    private Double todayCarbs;
    private Double todayFat;
}
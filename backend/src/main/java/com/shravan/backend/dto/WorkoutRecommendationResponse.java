package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkoutRecommendationResponse {

    private String fitnessGoal;

    private String workoutType;

    private String workoutTitle;

    private Integer durationWeeks;

    private Integer daysPerWeek;

    private Integer estimatedCaloriesBurned;

    private List<ExerciseResponse> exercises;
}
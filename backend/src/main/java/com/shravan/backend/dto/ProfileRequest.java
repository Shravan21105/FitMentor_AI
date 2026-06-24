package com.shravan.backend.dto;

import com.shravan.backend.entity.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProfileRequest {

    @NotNull(message = "Age is required")
    @Min(value = 10, message = "Age must be at least 10")
    @Max(value = 100, message = "Age must be less than 100")
    private Integer age;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Height is required")
    @Positive(message = "Height must be positive")
    private Double height;

    @NotNull(message = "Current weight is required")
    @Positive(message = "Current weight must be positive")
    private Double currentWeight;

    @Positive(message = "Starting weight must be positive")
    private Double startingWeight;

    @NotNull(message = "Target weight is required")
    @Positive(message = "Target weight must be positive")
    private Double targetWeight;

    @NotNull(message = "Activity level is required")
    private ActivityLevel activityLevel;

    @NotNull(message = "Fitness goal is required")
    private FitnessGoal fitnessGoal;

    @NotNull(message = "Workout type is required")
    private WorkoutType workoutType;
}
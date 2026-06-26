package com.shravan.backend.dto;

import com.shravan.backend.entity.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ExerciseRequest {

    @NotBlank(message = "Exercise name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Muscle group is required")
    private MuscleGroup muscleGroup;

    @NotNull(message = "Equipment is required")
    private Equipment equipment;

    @NotNull(message = "Difficulty is required")
    private Difficulty difficulty;

    @NotNull(message = "Exercise type is required")
    private ExerciseType exerciseType;

    @NotBlank(message = "Instructions are required")
    private String instructions;

    private String tips;

    @Positive
    private Double caloriesBurnedPerMinute;

    private Boolean compoundExercise;

    private Boolean premiumExercise;

    private String imageUrl;

    private String videoUrl;
}
package com.shravan.backend.dto;

import com.shravan.backend.entity.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseResponse {

    private Long id;

    private String name;

    private String description;

    private MuscleGroup muscleGroup;

    private Equipment equipment;

    private Difficulty difficulty;

    private ExerciseType exerciseType;

    private String instructions;

    private String tips;

    private Double caloriesBurnedPerMinute;

    private Boolean compoundExercise;

    private Boolean premiumExercise;

    private String imageUrl;

    private String videoUrl;
}
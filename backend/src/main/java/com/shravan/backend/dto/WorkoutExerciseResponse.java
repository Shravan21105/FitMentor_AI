package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutExerciseResponse {

    private String exerciseName;
    private Integer sets;
    private Integer reps;
    private Integer restSeconds;
}
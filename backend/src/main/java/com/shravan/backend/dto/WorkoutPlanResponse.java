package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkoutPlanResponse {

    private Long id;

    private String name;

    private String description;

    private List<WorkoutExerciseResponse> exercises;
}
package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutCompletionResponse {

    private String message;

    private Long workoutPlanId;

    private Boolean completed;
}
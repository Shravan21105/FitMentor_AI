package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgressResponse {

    private Double startingWeight;

    private Double currentWeight;

    private Double targetWeight;

    private Double weightLost;

    private Double weightRemaining;

    private Double goalCompletionPercentage;

    private Integer currentStreak;

    private Integer workoutsCompleted;
}
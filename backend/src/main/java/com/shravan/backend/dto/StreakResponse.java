package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StreakResponse {

    private Integer currentStreak;

    private Integer totalWorkoutsCompleted;
}
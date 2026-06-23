package com.shravan.backend.service;

import com.shravan.backend.dto.WorkoutPlanResponse;

public interface WorkoutRecommendationService {

    WorkoutPlanResponse getRecommendedWorkout();
}
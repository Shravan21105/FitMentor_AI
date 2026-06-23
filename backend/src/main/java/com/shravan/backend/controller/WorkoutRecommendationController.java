package com.shravan.backend.controller;

import com.shravan.backend.dto.WorkoutPlanResponse;
import com.shravan.backend.service.WorkoutRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutRecommendationController {

    private final WorkoutRecommendationService
            workoutRecommendationService;

    @GetMapping("/recommended")
    public WorkoutPlanResponse getRecommendedWorkout() {

        return workoutRecommendationService
                .getRecommendedWorkout();
    }
}
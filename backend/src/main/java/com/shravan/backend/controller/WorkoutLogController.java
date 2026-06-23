package com.shravan.backend.controller;

import com.shravan.backend.dto.WorkoutCompletionRequest;
import com.shravan.backend.dto.WorkoutCompletionResponse;
import com.shravan.backend.service.WorkoutLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutLogController {

    private final WorkoutLogService
            workoutLogService;

    @PostMapping("/complete")
    public WorkoutCompletionResponse
    completeWorkout(
            @RequestBody
            WorkoutCompletionRequest request
    ) {

        return workoutLogService
                .completeWorkout(request);
    }
}
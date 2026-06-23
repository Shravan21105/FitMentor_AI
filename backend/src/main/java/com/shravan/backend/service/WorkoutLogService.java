package com.shravan.backend.service;

import com.shravan.backend.dto.WorkoutCompletionRequest;
import com.shravan.backend.dto.WorkoutCompletionResponse;

public interface WorkoutLogService {

    WorkoutCompletionResponse completeWorkout(
            WorkoutCompletionRequest request
    );
}
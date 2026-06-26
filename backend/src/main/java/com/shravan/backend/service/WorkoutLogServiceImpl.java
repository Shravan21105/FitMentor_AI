package com.shravan.backend.service;

import com.shravan.backend.dto.WorkoutCompletionRequest;
import com.shravan.backend.dto.WorkoutCompletionResponse;
import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WorkoutLog;
import com.shravan.backend.entity.WorkoutPlan;
import com.shravan.backend.exception.UserNotFoundException;
import com.shravan.backend.exception.WorkoutLogNotFoundException;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.repository.WorkoutLogRepository;
import com.shravan.backend.repository.WorkoutPlanRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WorkoutLogServiceImpl
        implements WorkoutLogService {

    private final WorkoutLogRepository workoutLogRepository;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final CurrentUserService currentUserService;

    @Override
    public WorkoutCompletionResponse completeWorkout(
            WorkoutCompletionRequest request
    ) {

        User user =
                currentUserService.getCurrentUser();

        WorkoutPlan workoutPlan =
                workoutPlanRepository
                        .findById(
                                request.getWorkoutPlanId()
                        )
                        .orElseThrow(() ->
                                new WorkoutLogNotFoundException(
                                        "Workout plan not found"
                                ));

        WorkoutLog workoutLog =
                WorkoutLog.builder()
                        .user(user)
                        .workoutPlan(workoutPlan)
                        .completed(true)
                        .completedDate(
                                LocalDate.now()
                        )
                        .build();

        workoutLogRepository.save(workoutLog);

        return WorkoutCompletionResponse
                .builder()
                .message(
                        "Workout completed successfully"
                )
                .workoutPlanId(
                        workoutPlan.getId()
                )
                .completed(true)
                .build();
    }
}
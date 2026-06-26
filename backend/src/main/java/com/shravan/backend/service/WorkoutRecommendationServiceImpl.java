package com.shravan.backend.service;

import com.shravan.backend.dto.WorkoutExerciseResponse;
import com.shravan.backend.dto.WorkoutPlanResponse;
import com.shravan.backend.entity.*;
import com.shravan.backend.exception.ProfileNotFoundException;
import com.shravan.backend.exception.UserNotFoundException;
import com.shravan.backend.exception.WorkoutPlanNotFoundException;
import com.shravan.backend.repository.ProfileRepository;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.repository.WorkoutExerciseRepository;
import com.shravan.backend.repository.WorkoutPlanRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutRecommendationServiceImpl
        implements WorkoutRecommendationService {

    private final ProfileRepository profileRepository;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final CurrentUserService currentUserService;


    @Override
    public WorkoutPlanResponse getRecommendedWorkout() {

        User user =
                currentUserService.getCurrentUser();

        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() ->
                        new ProfileNotFoundException(
                                "Profile not found"
                        ));

        WorkoutGoal workoutGoal =
                mapFitnessGoal(
                        profile.getFitnessGoal()
                );

        WorkoutType workoutType =
                WorkoutType.GYM;

        List<WorkoutPlan> plans =
                workoutPlanRepository
                        .findByGoalAndWorkoutType(
                                workoutGoal,
                                workoutType
                        );

        if (plans.isEmpty()) {
            throw new WorkoutPlanNotFoundException(
                    "No workout plan found"
            );
        }

        WorkoutPlan plan = plans.get(0);

        List<WorkoutExerciseResponse> exercises =
                workoutExerciseRepository
                        .findByWorkoutPlan(plan)
                        .stream()
                        .map(exercise ->
                                WorkoutExerciseResponse
                                        .builder()
                                        .exerciseName(
                                                exercise.getExerciseName()
                                        )
                                        .sets(
                                                exercise.getSets()
                                        )
                                        .reps(
                                                exercise.getReps()
                                        )
                                        .restSeconds(
                                                exercise.getRestSeconds()
                                        )
                                        .build()
                        )
                        .toList();

        return WorkoutPlanResponse.builder()
                .id(plan.getId())
                .name(plan.getName())
                .description(plan.getDescription())
                .exercises(exercises)
                .build();
    }

    private WorkoutGoal mapFitnessGoal(
            FitnessGoal fitnessGoal
    ) {

        return switch (fitnessGoal) {

            case WEIGHT_LOSS ->
                    WorkoutGoal.FAT_LOSS;

            case MUSCLE_GAIN ->
                    WorkoutGoal.MUSCLE_GAIN;

            case GENERAL_FITNESS ->
                    WorkoutGoal.GENERAL_FITNESS;

            case WEIGHT_GAIN ->
                    WorkoutGoal.STRENGTH;
        };
    }
}
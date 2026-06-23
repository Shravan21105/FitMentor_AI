package com.shravan.backend.config;

import com.shravan.backend.entity.*;
import com.shravan.backend.repository.WorkoutExerciseRepository;
import com.shravan.backend.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkoutDataLoader
        implements CommandLineRunner {

    private final WorkoutPlanRepository
            workoutPlanRepository;

    private final WorkoutExerciseRepository
            workoutExerciseRepository;

    @Override
    public void run(String... args) {

        if(workoutPlanRepository.count() > 0){
            return;
        }

        WorkoutPlan fatLossGym =
                workoutPlanRepository.save(

                        WorkoutPlan.builder()
                                .name("Fat Loss Beginner Gym")
                                .goal(
                                        WorkoutGoal.FAT_LOSS
                                )
                                .workoutType(
                                        WorkoutType.GYM
                                )
                                .description(
                                        "Beginner fat loss gym plan"
                                )
                                .build()
                );

        workoutExerciseRepository.save(
                WorkoutExercise.builder()
                        .exerciseName("Treadmill")
                        .sets(1)
                        .reps(20)
                        .restSeconds(0)
                        .workoutPlan(fatLossGym)
                        .build()
        );

        workoutExerciseRepository.save(
                WorkoutExercise.builder()
                        .exerciseName("Bodyweight Squats")
                        .sets(3)
                        .reps(15)
                        .restSeconds(60)
                        .workoutPlan(fatLossGym)
                        .build()
        );

        workoutExerciseRepository.save(
                WorkoutExercise.builder()
                        .exerciseName("Lat Pulldown")
                        .sets(3)
                        .reps(12)
                        .restSeconds(60)
                        .workoutPlan(fatLossGym)
                        .build()
        );

        workoutExerciseRepository.save(
                WorkoutExercise.builder()
                        .exerciseName("Plank")
                        .sets(3)
                        .reps(1)
                        .restSeconds(45)
                        .workoutPlan(fatLossGym)
                        .build()
        );
    }
}
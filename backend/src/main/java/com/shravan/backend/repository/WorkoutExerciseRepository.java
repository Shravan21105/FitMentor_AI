package com.shravan.backend.repository;

import com.shravan.backend.entity.WorkoutExercise;
import com.shravan.backend.entity.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutExerciseRepository
        extends JpaRepository<WorkoutExercise, Long> {

    List<WorkoutExercise> findByWorkoutPlan(
            WorkoutPlan workoutPlan
    );
}
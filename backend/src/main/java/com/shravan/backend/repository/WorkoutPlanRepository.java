package com.shravan.backend.repository;

import com.shravan.backend.entity.WorkoutGoal;
import com.shravan.backend.entity.WorkoutPlan;
import com.shravan.backend.entity.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutPlanRepository
        extends JpaRepository<WorkoutPlan, Long> {

    List<WorkoutPlan> findByGoalAndWorkoutType(
            WorkoutGoal goal,
            WorkoutType workoutType
    );
}
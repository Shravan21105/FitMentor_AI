package com.shravan.backend.repository;

import com.shravan.backend.entity.Difficulty;
import com.shravan.backend.entity.Equipment;
import com.shravan.backend.entity.Exercise;
import com.shravan.backend.entity.ExerciseType;
import com.shravan.backend.entity.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository
        extends JpaRepository<Exercise, Long> {

    List<Exercise> findByMuscleGroup(
            MuscleGroup muscleGroup
    );

    List<Exercise> findByDifficulty(
            Difficulty difficulty
    );

    List<Exercise> findByEquipment(
            Equipment equipment
    );

    List<Exercise> findByExerciseType(
            ExerciseType exerciseType
    );

    List<Exercise> findByNameContainingIgnoreCase(
            String keyword
    );
}
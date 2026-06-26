package com.shravan.backend.service;

import com.shravan.backend.dto.ExerciseRequest;
import com.shravan.backend.dto.ExerciseResponse;
import com.shravan.backend.entity.Difficulty;
import com.shravan.backend.entity.Equipment;
import com.shravan.backend.entity.ExerciseType;
import com.shravan.backend.entity.MuscleGroup;

import java.util.List;

public interface ExerciseService {

    ExerciseResponse createExercise(
            ExerciseRequest request
    );

    ExerciseResponse updateExercise(
            Long id,
            ExerciseRequest request
    );

    void deleteExercise(
            Long id
    );

    ExerciseResponse getExerciseById(
            Long id
    );

    List<ExerciseResponse> getAllExercises();

    List<ExerciseResponse> getExercisesByMuscleGroup(
            MuscleGroup muscleGroup
    );

    List<ExerciseResponse> getExercisesByEquipment(
            Equipment equipment
    );

    List<ExerciseResponse> getExercisesByDifficulty(
            Difficulty difficulty
    );

    List<ExerciseResponse> getExercisesByType(
            ExerciseType exerciseType
    );

    List<ExerciseResponse> searchExercises(
            String keyword
    );
}
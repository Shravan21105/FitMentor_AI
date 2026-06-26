package com.shravan.backend.service;

import com.shravan.backend.dto.ExerciseRequest;
import com.shravan.backend.dto.ExerciseResponse;
import com.shravan.backend.entity.*;
import com.shravan.backend.exception.ExerciseNotFoundException;
import com.shravan.backend.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl
        implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    public ExerciseResponse createExercise(
            ExerciseRequest request
    ) {

        Exercise exercise = Exercise.builder()
                .name(request.getName())
                .description(request.getDescription())
                .muscleGroup(request.getMuscleGroup())
                .equipment(request.getEquipment())
                .difficulty(request.getDifficulty())
                .exerciseType(request.getExerciseType())
                .instructions(request.getInstructions())
                .tips(request.getTips())
                .caloriesBurnedPerMinute(request.getCaloriesBurnedPerMinute())
                .compoundExercise(request.getCompoundExercise())
                .premiumExercise(request.getPremiumExercise())
                .imageUrl(request.getImageUrl())
                .videoUrl(request.getVideoUrl())
                .build();

        exerciseRepository.save(exercise);

        return mapToResponse(exercise);
    }

    @Override
    public ExerciseResponse updateExercise(
            Long id,
            ExerciseRequest request
    ) {

        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() ->
                        new ExerciseNotFoundException(
                                "Exercise not found."
                        )
                );

        exercise.setName(request.getName());
        exercise.setDescription(request.getDescription());
        exercise.setMuscleGroup(request.getMuscleGroup());
        exercise.setEquipment(request.getEquipment());
        exercise.setDifficulty(request.getDifficulty());
        exercise.setExerciseType(request.getExerciseType());
        exercise.setInstructions(request.getInstructions());
        exercise.setTips(request.getTips());
        exercise.setCaloriesBurnedPerMinute(request.getCaloriesBurnedPerMinute());
        exercise.setCompoundExercise(request.getCompoundExercise());
        exercise.setPremiumExercise(request.getPremiumExercise());
        exercise.setImageUrl(request.getImageUrl());
        exercise.setVideoUrl(request.getVideoUrl());

        exerciseRepository.save(exercise);

        return mapToResponse(exercise);
    }

    @Override
    public void deleteExercise(
            Long id
    ) {

        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() ->
                        new ExerciseNotFoundException(
                                "Exercise not found."
                        )
                );

        exerciseRepository.delete(exercise);
    }

    @Override
    public ExerciseResponse getExerciseById(
            Long id
    ) {

        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() ->
                        new ExerciseNotFoundException(
                                "Exercise not found."
                        )
                );

        return mapToResponse(exercise);
    }

    @Override
    public List<ExerciseResponse> getAllExercises() {

        return exerciseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseResponse> getExercisesByMuscleGroup(
            MuscleGroup muscleGroup
    ) {

        return exerciseRepository.findByMuscleGroup(muscleGroup)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseResponse> getExercisesByEquipment(
            Equipment equipment
    ) {

        return exerciseRepository.findByEquipment(equipment)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseResponse> getExercisesByDifficulty(
            Difficulty difficulty
    ) {

        return exerciseRepository.findByDifficulty(difficulty)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseResponse> getExercisesByType(
            ExerciseType exerciseType
    ) {

        return exerciseRepository.findByExerciseType(exerciseType)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseResponse> searchExercises(
            String keyword
    ) {

        return exerciseRepository.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ExerciseResponse mapToResponse(
            Exercise exercise
    ) {

        return ExerciseResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .description(exercise.getDescription())
                .muscleGroup(exercise.getMuscleGroup())
                .equipment(exercise.getEquipment())
                .difficulty(exercise.getDifficulty())
                .exerciseType(exercise.getExerciseType())
                .instructions(exercise.getInstructions())
                .tips(exercise.getTips())
                .caloriesBurnedPerMinute(exercise.getCaloriesBurnedPerMinute())
                .compoundExercise(exercise.getCompoundExercise())
                .premiumExercise(exercise.getPremiumExercise())
                .imageUrl(exercise.getImageUrl())
                .videoUrl(exercise.getVideoUrl())
                .build();
    }
}
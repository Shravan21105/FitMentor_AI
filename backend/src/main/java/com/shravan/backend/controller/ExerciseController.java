package com.shravan.backend.controller;

import com.shravan.backend.dto.ExerciseRequest;
import com.shravan.backend.dto.ExerciseResponse;
import com.shravan.backend.entity.Difficulty;
import com.shravan.backend.entity.Equipment;
import com.shravan.backend.entity.ExerciseType;
import com.shravan.backend.entity.MuscleGroup;
import com.shravan.backend.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ExerciseResponse createExercise(
            @Valid @RequestBody ExerciseRequest request
    ) {

        return exerciseService.createExercise(request);
    }

    @PutMapping("/{id}")
    public ExerciseResponse updateExercise(
            @PathVariable Long id,
            @Valid @RequestBody ExerciseRequest request
    ) {

        return exerciseService.updateExercise(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(
            @PathVariable Long id
    ) {

        exerciseService.deleteExercise(id);
    }

    @GetMapping("/{id}")
    public ExerciseResponse getExerciseById(
            @PathVariable Long id
    ) {

        return exerciseService.getExerciseById(id);
    }

    @GetMapping
    public List<ExerciseResponse> getAllExercises() {

        return exerciseService.getAllExercises();
    }

    @GetMapping("/muscle/{muscleGroup}")
    public List<ExerciseResponse> getByMuscleGroup(
            @PathVariable MuscleGroup muscleGroup
    ) {

        return exerciseService.getExercisesByMuscleGroup(muscleGroup);
    }

    @GetMapping("/equipment/{equipment}")
    public List<ExerciseResponse> getByEquipment(
            @PathVariable Equipment equipment
    ) {

        return exerciseService.getExercisesByEquipment(equipment);
    }

    @GetMapping("/difficulty/{difficulty}")
    public List<ExerciseResponse> getByDifficulty(
            @PathVariable Difficulty difficulty
    ) {

        return exerciseService.getExercisesByDifficulty(difficulty);
    }

    @GetMapping("/type/{exerciseType}")
    public List<ExerciseResponse> getByType(
            @PathVariable ExerciseType exerciseType
    ) {

        return exerciseService.getExercisesByType(exerciseType);
    }

    @GetMapping("/search")
    public List<ExerciseResponse> searchExercises(
            @RequestParam String keyword
    ) {

        return exerciseService.searchExercises(keyword);
    }
}
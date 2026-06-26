package com.shravan.backend.controller;

import com.shravan.backend.dto.MealLogRequest;
import com.shravan.backend.dto.MealLogResponse;
import com.shravan.backend.dto.MealSummaryResponse;
import com.shravan.backend.service.MealLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor
public class MealLogController {

    private final MealLogService mealLogService;

    @PostMapping
    public MealLogResponse addMeal(
            @Valid @RequestBody MealLogRequest request
    ) {

        return mealLogService.addMeal(request);
    }

    @GetMapping("/today")
    public List<MealLogResponse> getTodayMeals() {

        return mealLogService.getTodayMeals();
    }

    @GetMapping("/history")
    public List<MealLogResponse> getMealHistory() {

        return mealLogService.getMealHistory();
    }

    @GetMapping("/summary")
    public MealSummaryResponse getTodaySummary() {

        return mealLogService.getTodaySummary();
    }

    @DeleteMapping("/{id}")
    public void deleteMeal(
            @PathVariable Long id
    ) {

        mealLogService.deleteMeal(id);
    }
}
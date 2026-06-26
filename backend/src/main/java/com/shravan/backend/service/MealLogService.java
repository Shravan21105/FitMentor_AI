package com.shravan.backend.service;

import com.shravan.backend.dto.MealLogRequest;
import com.shravan.backend.dto.MealLogResponse;
import com.shravan.backend.dto.MealSummaryResponse;

import java.util.List;

public interface MealLogService {

    MealLogResponse addMeal(
            MealLogRequest request
    );

    List<MealLogResponse> getTodayMeals();

    List<MealLogResponse> getMealHistory();

    MealSummaryResponse getTodaySummary();

    void deleteMeal(
            Long id
    );
}
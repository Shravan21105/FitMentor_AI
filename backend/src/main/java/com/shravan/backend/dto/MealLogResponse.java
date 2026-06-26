package com.shravan.backend.dto;

import com.shravan.backend.entity.MealType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class MealLogResponse {

    private Long id;

    private MealType mealType;

    private String foodName;

    private Double quantity;

    private String unit;

    private Double calories;

    private Double protein;

    private Double carbs;

    private Double fat;

    private LocalDate loggedDate;

    private LocalDateTime loggedAt;
}
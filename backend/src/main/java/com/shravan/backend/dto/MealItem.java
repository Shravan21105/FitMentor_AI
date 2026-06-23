package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealItem {

    private String mealType;

    private String foodName;

    private Integer calories;

    private Integer protein;

    private Integer carbs;

    private Integer fats;
}
package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DietResponse {

    private String planName;

    private String description;

    private Integer totalCalories;

    private List<MealItem> meals;
}
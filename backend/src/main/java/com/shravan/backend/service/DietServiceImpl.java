package com.shravan.backend.service;

import com.shravan.backend.dto.DietResponse;
import com.shravan.backend.dto.MealItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietServiceImpl implements DietService {

    @Override
    public DietResponse getRecommendedDiet() {

        List<MealItem> meals = List.of(

                MealItem.builder()
                        .mealType("Breakfast")
                        .foodName("Oats + Milk + Banana")
                        .calories(500)
                        .build(),

                MealItem.builder()
                        .mealType("Lunch")
                        .foodName("Dal + Rice + Salad")
                        .calories(700)
                        .build(),

                MealItem.builder()
                        .mealType("Dinner")
                        .foodName("Roti + Paneer + Vegetables")
                        .calories(600)
                        .build()
        );

        return DietResponse.builder()
                .planName("Basic Weight Loss Plan")
                .description("Starter vegetarian diet plan")
                .totalCalories(1800)
                .meals(meals)
                .build();
    }
}
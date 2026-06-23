package com.shravan.backend.repository;

import com.shravan.backend.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository
        extends JpaRepository<Meal, Long> {
}
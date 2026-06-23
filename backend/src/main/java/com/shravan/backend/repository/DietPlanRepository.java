package com.shravan.backend.repository;

import com.shravan.backend.entity.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietPlanRepository
        extends JpaRepository<DietPlan, Long> {
}
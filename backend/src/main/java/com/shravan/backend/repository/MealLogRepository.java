package com.shravan.backend.repository;

import com.shravan.backend.entity.MealLog;
import com.shravan.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealLogRepository
        extends JpaRepository<MealLog, Long> {

    List<MealLog> findByUserOrderByLoggedAtDesc(
            User user
    );

    List<MealLog> findByUserAndLoggedDateOrderByLoggedAtDesc(
            User user,
            LocalDate loggedDate
    );
}
package com.shravan.backend.repository;

import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WaterLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WaterLogRepository
        extends JpaRepository<WaterLog, Long> {

    List<WaterLog> findByUserOrderByLoggedAtDesc(
            User user
    );

    List<WaterLog> findByUserAndLoggedDateOrderByLoggedAtDesc(
            User user,
            LocalDate loggedDate
    );
}
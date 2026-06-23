package com.shravan.backend.repository;

import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WeightLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightLogRepository
        extends JpaRepository<WeightLog, Long> {

    List<WeightLog> findByUserOrderByLoggedDateDesc(
            User user
    );
}
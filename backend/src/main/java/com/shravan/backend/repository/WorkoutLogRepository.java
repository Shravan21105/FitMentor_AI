package com.shravan.backend.repository;

import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutLogRepository
        extends JpaRepository<WorkoutLog, Long> {

    List<WorkoutLog> findByUserOrderByCompletedDateDesc(
            User user
    );

    List<WorkoutLog> findByUserAndCompletedTrueOrderByCompletedDateDesc(
            User user
    );
}
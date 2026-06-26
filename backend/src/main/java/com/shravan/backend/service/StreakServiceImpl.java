package com.shravan.backend.service;

import com.shravan.backend.dto.StreakResponse;
import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WorkoutLog;
import com.shravan.backend.exception.UserNotFoundException;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.repository.WorkoutLogRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StreakServiceImpl
        implements StreakService {

    private final WorkoutLogRepository workoutLogRepository;
    private final CurrentUserService currentUserService;

    @Override
    public StreakResponse getStreak() {

        User user =
                currentUserService.getCurrentUser();

        List<WorkoutLog> logs =
                workoutLogRepository
                        .findByUserAndCompletedTrueOrderByCompletedDateDesc(
                                user
                        );

        int streak =
                calculateCurrentStreak(logs);

        return StreakResponse.builder()
                .currentStreak(streak)
                .totalWorkoutsCompleted(
                        logs.size()
                )
                .build();
    }

    private int calculateCurrentStreak(
            List<WorkoutLog> logs
    ) {

        if (logs.isEmpty()) {
            return 0;
        }

        int streak = 0;

        LocalDate expectedDate =
                LocalDate.now();

        for (WorkoutLog log : logs) {

            if (log.getCompletedDate()
                    .equals(expectedDate)) {

                streak++;

                expectedDate =
                        expectedDate.minusDays(1);

            } else {

                break;
            }
        }

        return streak;
    }
}
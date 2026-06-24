package com.shravan.backend.service;

import com.shravan.backend.dto.ProgressResponse;
import com.shravan.backend.entity.Profile;
import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WeightLog;
import com.shravan.backend.repository.ProfileRepository;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.repository.WeightLogRepository;
import com.shravan.backend.repository.WorkoutLogRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl
        implements ProgressService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final WeightLogRepository weightLogRepository;
    private final WorkoutLogRepository workoutLogRepository;

    @Override
    public ProgressResponse getProgress() {

        String email =
                SecurityUtils.getCurrentUserEmail();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));

        Profile profile =
                profileRepository.findByUser(user)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Profile not found"
                                ));

        double currentWeight =
                getCurrentWeight(user, profile);

        double startingWeight =
                profile.getStartingWeight() != null
                        ? profile.getStartingWeight()
                        : currentWeight;

        double targetWeight =
                profile.getTargetWeight();

        double weightLost =
                startingWeight - currentWeight;

        double weightRemaining =
                currentWeight - targetWeight;

        double goalCompletion =
                calculateGoalCompletion(
                        startingWeight,
                        currentWeight,
                        targetWeight
                );

        int workoutsCompleted =
                workoutLogRepository
                        .findByUserAndCompletedTrueOrderByCompletedDateDesc(
                                user
                        )
                        .size();

        int currentStreak =
                calculateCurrentStreak(user);

        return ProgressResponse.builder()
                .startingWeight(startingWeight)
                .currentWeight(currentWeight)
                .targetWeight(targetWeight)
                .weightLost(round(weightLost))
                .weightRemaining(round(weightRemaining))
                .goalCompletionPercentage(
                        round(goalCompletion)
                )
                .currentStreak(currentStreak)
                .workoutsCompleted(workoutsCompleted)
                .build();
    }

    private double getCurrentWeight(
            User user,
            Profile profile
    ) {

        List<WeightLog> logs =
                weightLogRepository
                        .findByUserOrderByLoggedDateDesc(
                                user
                        );

        if (!logs.isEmpty()) {
            return logs.get(0).getWeight();
        }

        return profile.getCurrentWeight();
    }

    private double calculateGoalCompletion(
            double startingWeight,
            double currentWeight,
            double targetWeight
    ) {

        double totalJourney =
                startingWeight - targetWeight;

        if (totalJourney <= 0) {
            return 0;
        }

        double completed =
                startingWeight - currentWeight;

        return (completed / totalJourney) * 100;
    }

    private int calculateCurrentStreak(
            User user
    ) {

        List<LocalDate> dates =
                workoutLogRepository
                        .findByUserAndCompletedTrueOrderByCompletedDateDesc(
                                user
                        )
                        .stream()
                        .map(log -> log.getCompletedDate())
                        .distinct()
                        .toList();

        System.out.println("=================================");
        System.out.println("TODAY = " + LocalDate.now());
        System.out.println("DATES FROM DB = " + dates);

        for (LocalDate date : dates) {
            System.out.println("WORKOUT DATE = " + date);
        }

        System.out.println("=================================");

        if (dates.isEmpty()) {
            return 0;
        }

        int streak = 0;

        LocalDate expectedDate =
                LocalDate.now();

        for (LocalDate date : dates) {

            System.out.println(
                    "Comparing " + date +
                            " with " + expectedDate
            );

            if (date.equals(expectedDate)) {

                streak++;

                expectedDate =
                        expectedDate.minusDays(1);

            } else {

                break;
            }
        }

        System.out.println("FINAL STREAK = " + streak);

        return streak;
    }

    private double round(
            double value
    ) {

        return Math.round(value * 100.0)
                / 100.0;
    }
}
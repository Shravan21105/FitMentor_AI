package com.shravan.backend.service;

import com.shravan.backend.dto.DashboardResponse;
import com.shravan.backend.entity.Profile;
import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WeightLog;
import com.shravan.backend.entity.WorkoutLog;
import com.shravan.backend.exception.ProfileNotFoundException;
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
public class DashboardServiceImpl
        implements DashboardService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final WeightLogRepository weightLogRepository;
    private final WorkoutLogRepository workoutLogRepository;

    @Override
    public DashboardResponse getDashboard() {

        String email = SecurityUtils.getCurrentUserEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() ->
                        new ProfileNotFoundException(
                                "Profile not found"
                        ));

        double currentWeight =
                getCurrentWeight(user, profile);

        double startingWeight =
                profile.getStartingWeight() != null
                        ? profile.getStartingWeight()
                        : profile.getCurrentWeight();

        double targetWeight =
                profile.getTargetWeight();

        double weightLost =
                startingWeight - currentWeight;

        double remainingWeight =
                currentWeight - targetWeight;

        double goalCompletion =
                calculateGoalCompletion(
                        startingWeight,
                        currentWeight,
                        targetWeight
                );

        double bmi = calculateBMI(
                currentWeight,
                profile.getHeight()
        );

        double bmr =
                calculateBMR(profile);

        double dailyCalories =
                calculateDailyCalories(
                        bmr,
                        profile.getActivityLevel().name()
                );

        int totalWorkouts =
                workoutLogRepository
                        .findByUserAndCompletedTrueOrderByCompletedDateDesc(
                                user
                        )
                        .size();

        int currentStreak =
                calculateCurrentStreak(user);

        return DashboardResponse.builder()
                .startingWeight(startingWeight)
                .currentWeight(currentWeight)
                .targetWeight(targetWeight)
                .weightLost(round(weightLost))
                .remainingWeight(round(remainingWeight))
                .goalCompletionPercentage(
                        round(goalCompletion)
                )
                .currentStreak(currentStreak)
                .totalWorkoutsCompleted(
                        totalWorkouts
                )
                .bmi(round(bmi))
                .dailyCalories(round(dailyCalories))
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

    private double calculateBMI(
            double weight,
            double heightCm
    ) {

        double heightM = heightCm / 100.0;

        return weight /
                (heightM * heightM);
    }

    private double calculateBMR(
            Profile profile
    ) {

        if (profile.getGender().name().equals("MALE")) {

            return 10 * profile.getCurrentWeight()
                    + 6.25 * profile.getHeight()
                    - 5 * profile.getAge()
                    + 5;
        }

        return 10 * profile.getCurrentWeight()
                + 6.25 * profile.getHeight()
                - 5 * profile.getAge()
                - 161;
    }

    private double calculateDailyCalories(
            double bmr,
            String activityLevel
    ) {

        return switch (activityLevel) {

            case "SEDENTARY" ->
                    bmr * 1.2;

            case "LIGHTLY_ACTIVE" ->
                    bmr * 1.375;

            case "MODERATELY_ACTIVE" ->
                    bmr * 1.55;

            case "VERY_ACTIVE" ->
                    bmr * 1.725;

            default ->
                    bmr * 1.2;
        };
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

        List<WorkoutLog> logs =
                workoutLogRepository
                        .findByUserAndCompletedTrueOrderByCompletedDateDesc(
                                user
                        );

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

    private double round(
            double value
    ) {

        return Math.round(value * 100.0)
                / 100.0;
    }
}
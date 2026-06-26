package com.shravan.backend.service;

import com.shravan.backend.dto.FitnessAssessmentResponse;
import com.shravan.backend.entity.Gender;
import com.shravan.backend.entity.Profile;
import com.shravan.backend.entity.User;
import com.shravan.backend.exception.ProfileNotFoundException;
import com.shravan.backend.exception.UserNotFoundException;
import com.shravan.backend.repository.ProfileRepository;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FitnessAssessmentServiceImpl
        implements FitnessAssessmentService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final CurrentUserService currentUserService;


    @Override
    public FitnessAssessmentResponse calculateAssessment() {

        User user =
                currentUserService.getCurrentUser();

        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() ->
                        new ProfileNotFoundException(
                                "Profile not found"
                        ));

        double bmi = calculateBMI(
                profile.getCurrentWeight(),
                profile.getHeight()
        );

        String bmiCategory = getBMICategory(bmi);

        double bmr = calculateBMR(profile);

        double dailyCalories =
                calculateDailyCalories(
                        bmr,
                        profile.getActivityLevel().name()
                );

        return FitnessAssessmentResponse.builder()
                .bmi(round(bmi))
                .bmiCategory(bmiCategory)
                .bmr(round(bmr))
                .dailyCalories(round(dailyCalories))
                .build();
    }

    private double calculateBMI(
            double weight,
            double heightCm
    ) {

        double heightM = heightCm / 100.0;

        return weight /
                (heightM * heightM);
    }

    private String getBMICategory(
            double bmi
    ) {

        if (bmi < 18.5) return "Underweight";

        if (bmi < 25) return "Normal";

        if (bmi < 30) return "Overweight";

        return "Obese";
    }

    private double calculateBMR(
            Profile profile
    ) {

        if(profile.getGender() == Gender.MALE){

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

    private double round(double value){

        return Math.round(value * 100.0)
                / 100.0;
    }
}
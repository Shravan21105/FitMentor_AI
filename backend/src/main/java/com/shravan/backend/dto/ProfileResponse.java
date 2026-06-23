package com.shravan.backend.dto;

import com.shravan.backend.entity.ActivityLevel;
import com.shravan.backend.entity.FitnessGoal;
import com.shravan.backend.entity.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {

    private Long id;

    private Integer age;

    private Gender gender;

    private Double height;

    private Double currentWeight;

    private Double targetWeight;

    private ActivityLevel activityLevel;

    private FitnessGoal fitnessGoal;
}
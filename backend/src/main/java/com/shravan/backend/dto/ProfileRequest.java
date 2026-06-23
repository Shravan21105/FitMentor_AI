package com.shravan.backend.dto;

import com.shravan.backend.entity.ActivityLevel;
import com.shravan.backend.entity.FitnessGoal;
import com.shravan.backend.entity.Gender;
import com.shravan.backend.entity.WorkoutType;
import lombok.Data;

@Data
public class ProfileRequest {

    private Integer age;

    private Gender gender;

    private Double height;

    private Double currentWeight;

    private Double startingWeight;

    private Double targetWeight;

    private ActivityLevel activityLevel;

    private FitnessGoal fitnessGoal;

    private WorkoutType workoutType;



}

package com.shravan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    @Enumerated(EnumType.STRING)
    private Equipment equipment;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @Column(length = 3000)
    private String instructions;

    @Column(length = 1000)
    private String tips;

    private Double caloriesBurnedPerMinute;

    private Boolean compoundExercise;

    private Boolean premiumExercise;

    private String imageUrl;

    private String videoUrl;
}
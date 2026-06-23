package com.shravan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workout_plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private WorkoutGoal goal;

    @Enumerated(EnumType.STRING)
    private WorkoutType workoutType;

    private String description;
}
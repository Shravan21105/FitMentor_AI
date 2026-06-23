package com.shravan.backend.entity;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double height;

    private double currentWeight;

    private double targetWeight;

    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    @Enumerated(EnumType.STRING)
    private FitnessGoal fitnessGoal;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            unique = true
    )
    private User user;
}

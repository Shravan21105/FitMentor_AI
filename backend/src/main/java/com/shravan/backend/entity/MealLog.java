package com.shravan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    private String foodName;

    private Double quantity;

    private String unit;

    private Double calories;

    private Double protein;

    private Double carbs;

    private Double fat;

    private LocalDate loggedDate;

    private LocalDateTime loggedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
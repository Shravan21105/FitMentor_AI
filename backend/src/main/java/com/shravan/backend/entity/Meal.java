package com.shravan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    private String foodName;

    private Integer calories;

    private Integer protein;

    private Integer carbs;

    private Integer fats;

    @ManyToOne
    @JoinColumn(name = "diet_plan_id")
    private DietPlan dietPlan;
}
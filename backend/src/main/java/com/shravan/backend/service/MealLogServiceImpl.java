package com.shravan.backend.service;

import com.shravan.backend.dto.MealLogRequest;
import com.shravan.backend.dto.MealLogResponse;
import com.shravan.backend.dto.MealSummaryResponse;
import com.shravan.backend.entity.MealLog;
import com.shravan.backend.entity.User;
import com.shravan.backend.exception.MealNotFoundException;
import com.shravan.backend.exception.UnauthorizedException;
import com.shravan.backend.repository.MealLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealLogServiceImpl
        implements MealLogService {

    private final MealLogRepository mealLogRepository;
    private final CurrentUserService currentUserService;

    @Override
    public MealLogResponse addMeal(
            MealLogRequest request
    ) {

        User user =
                currentUserService.getCurrentUser();

        MealLog mealLog =
                MealLog.builder()
                        .mealType(request.getMealType())
                        .foodName(request.getFoodName())
                        .quantity(request.getQuantity())
                        .unit(request.getUnit())
                        .calories(request.getCalories())
                        .protein(request.getProtein())
                        .carbs(request.getCarbs())
                        .fat(request.getFat())
                        .loggedDate(LocalDate.now())
                        .loggedAt(LocalDateTime.now())
                        .user(user)
                        .build();

        mealLogRepository.save(mealLog);

        return mapToResponse(mealLog);
    }

    @Override
    public List<MealLogResponse> getTodayMeals() {

        User user =
                currentUserService.getCurrentUser();

        return mealLogRepository
                .findByUserAndLoggedDateOrderByLoggedAtDesc(
                        user,
                        LocalDate.now()
                )
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<MealLogResponse> getMealHistory() {

        User user =
                currentUserService.getCurrentUser();

        return mealLogRepository
                .findByUserOrderByLoggedAtDesc(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public MealSummaryResponse getTodaySummary() {

        User user =
                currentUserService.getCurrentUser();

        List<MealLog> meals =
                mealLogRepository
                        .findByUserAndLoggedDateOrderByLoggedAtDesc(
                                user,
                                LocalDate.now()
                        );

        double calories =
                meals.stream()
                        .mapToDouble(MealLog::getCalories)
                        .sum();

        double protein =
                meals.stream()
                        .mapToDouble(MealLog::getProtein)
                        .sum();

        double carbs =
                meals.stream()
                        .mapToDouble(MealLog::getCarbs)
                        .sum();

        double fat =
                meals.stream()
                        .mapToDouble(MealLog::getFat)
                        .sum();

        double targetCalories = 2200;

        return MealSummaryResponse.builder()
                .todayCalories(round(calories))
                .targetCalories(targetCalories)
                .remainingCalories(
                        round(targetCalories - calories)
                )
                .protein(round(protein))
                .carbs(round(carbs))
                .fat(round(fat))
                .build();
    }

    @Override
    public void deleteMeal(
            Long id
    ) {

        User user =
                currentUserService.getCurrentUser();

        MealLog meal =
                mealLogRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new MealNotFoundException(
                                        "Meal not found"
                                ));

        if (meal.getUser().getId() != user.getId()) {

            throw new UnauthorizedException(
                    "You cannot delete another user's meal."
            );
        }

        mealLogRepository.delete(meal);
    }

    private MealLogResponse mapToResponse(
            MealLog meal
    ) {

        return MealLogResponse.builder()
                .id(meal.getId())
                .mealType(meal.getMealType())
                .foodName(meal.getFoodName())
                .quantity(meal.getQuantity())
                .unit(meal.getUnit())
                .calories(meal.getCalories())
                .protein(meal.getProtein())
                .carbs(meal.getCarbs())
                .fat(meal.getFat())
                .loggedDate(meal.getLoggedDate())
                .loggedAt(meal.getLoggedAt())
                .build();
    }

    private double round(
            double value
    ) {

        return Math.round(value * 100.0)
                / 100.0;
    }
}
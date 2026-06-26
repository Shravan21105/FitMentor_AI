package com.shravan.backend.service;

import com.shravan.backend.dto.WaterRequest;
import com.shravan.backend.dto.WaterResponse;
import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WaterLog;
import com.shravan.backend.exception.WaterLogNotFoundException;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.repository.WaterLogRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WaterLogServiceImpl
        implements WaterLogService {

    private final WaterLogRepository waterLogRepository;
    private final CurrentUserService currentUserService;

    @Override
    public WaterResponse addWater(
            WaterRequest request
    ) {

        User user =
                currentUserService.getCurrentUser();

        WaterLog waterLog =
                WaterLog.builder()
                        .amount(request.getAmount())
                        .loggedDate(LocalDate.now())
                        .loggedAt(LocalDateTime.now())
                        .user(user)
                        .build();

        waterLogRepository.save(waterLog);

        return mapToResponse(waterLog);
    }

    @Override
    public List<WaterResponse> getTodayWater() {

        User user =
                currentUserService.getCurrentUser();

        return waterLogRepository
                .findByUserAndLoggedDateOrderByLoggedAtDesc(
                        user,
                        LocalDate.now()
                )
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<WaterResponse> getHistory() {

        User user =
                currentUserService.getCurrentUser();

        return waterLogRepository
                .findByUserOrderByLoggedAtDesc(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteWater(
            Long id
    ) {

        User user =
                currentUserService.getCurrentUser();

        WaterLog waterLog =
                waterLogRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new WaterLogNotFoundException(
                                        "Water log not found"
                                ));

        if (waterLog.getUser().getId() != user.getId()) {

            throw new RuntimeException(
                    "You cannot delete another user's water log."
            );
        }

        waterLogRepository.delete(waterLog);
    }

    private WaterResponse mapToResponse(
            WaterLog waterLog
    ) {

        return WaterResponse.builder()
                .id(waterLog.getId())
                .amount(waterLog.getAmount())
                .loggedDate(waterLog.getLoggedDate())
                .loggedAt(waterLog.getLoggedAt())
                .build();
    }
}
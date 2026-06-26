package com.shravan.backend.service;

import com.shravan.backend.dto.WaterRequest;
import com.shravan.backend.dto.WaterResponse;
import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WaterLog;
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
    private final UserRepository userRepository;

    @Override
    public WaterResponse addWater(
            WaterRequest request
    ) {

        String email =
                SecurityUtils.getCurrentUserEmail();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));

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

        String email =
                SecurityUtils.getCurrentUserEmail();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));

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

        String email =
                SecurityUtils.getCurrentUserEmail();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));

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

        String email =
                SecurityUtils.getCurrentUserEmail();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));

        WaterLog waterLog =
                waterLogRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
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
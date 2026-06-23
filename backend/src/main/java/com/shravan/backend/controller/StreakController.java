package com.shravan.backend.controller;

import com.shravan.backend.dto.StreakResponse;
import com.shravan.backend.service.StreakService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/streak")
@RequiredArgsConstructor
public class StreakController {

    private final StreakService streakService;

    @GetMapping
    public StreakResponse getStreak() {

        return streakService.getStreak();
    }
}
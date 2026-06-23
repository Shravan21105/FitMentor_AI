package com.shravan.backend.controller;

import com.shravan.backend.dto.DietResponse;
import com.shravan.backend.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @GetMapping("/recommendation")
    public DietResponse getRecommendation() {

        return dietService.getRecommendedDiet();
    }
}
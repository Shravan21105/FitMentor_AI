package com.shravan.backend.controller;

import com.shravan.backend.dto.FitnessAssessmentResponse;
import com.shravan.backend.service.FitnessAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assessment")
@RequiredArgsConstructor
public class FitnessAssessmentController {

    private final FitnessAssessmentService
            fitnessAssessmentService;

    @GetMapping
    public FitnessAssessmentResponse
    getAssessment(){

        return fitnessAssessmentService
                .calculateAssessment();
    }
}
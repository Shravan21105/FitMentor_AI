package com.shravan.backend.controller;

import com.shravan.backend.dto.ProgressResponse;
import com.shravan.backend.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class ProgressController {

    private final ProgressService progressService;

    @GetMapping
    public ProgressResponse getProgress() {

        return progressService.getProgress();
    }
}
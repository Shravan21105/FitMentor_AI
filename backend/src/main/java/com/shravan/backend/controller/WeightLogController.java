package com.shravan.backend.controller;

import com.shravan.backend.dto.WeightLogRequest;
import com.shravan.backend.dto.WeightLogResponse;
import com.shravan.backend.service.WeightLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weights")
@RequiredArgsConstructor
public class WeightLogController {

    private final WeightLogService weightLogService;

    @PostMapping
    public WeightLogResponse addWeightLog(
            @Valid @RequestBody WeightLogRequest request
    ) {

        System.out.println(
                "CONTROLLER REACHED -> "
                        + request.getWeight()
        );

        return weightLogService
                .addWeightLog(request);
    }

    @GetMapping
    public List<WeightLogResponse> getWeightLogs() {
        return weightLogService.getWeightLogs();
    }

    @GetMapping("/latest")
    public WeightLogResponse getLatestWeight() {
        return weightLogService.getLatestWeight();
    }
}
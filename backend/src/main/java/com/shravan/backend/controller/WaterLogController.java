package com.shravan.backend.controller;

import com.shravan.backend.dto.WaterRequest;
import com.shravan.backend.dto.WaterResponse;
import com.shravan.backend.service.WaterLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/water")
@RequiredArgsConstructor
public class WaterLogController {

    private final WaterLogService waterLogService;

    @PostMapping
    public WaterResponse addWater(
            @Valid @RequestBody WaterRequest request
    ) {

        return waterLogService.addWater(request);
    }

    @GetMapping("/today")
    public List<WaterResponse> getTodayWater() {

        return waterLogService.getTodayWater();
    }

    @GetMapping("/history")
    public List<WaterResponse> getHistory() {

        return waterLogService.getHistory();
    }

    @DeleteMapping("/{id}")
    public void deleteWater(
            @PathVariable Long id
    ) {

        waterLogService.deleteWater(id);
    }
}
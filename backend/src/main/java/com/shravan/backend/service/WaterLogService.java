package com.shravan.backend.service;

import com.shravan.backend.dto.WaterRequest;
import com.shravan.backend.dto.WaterResponse;

import java.util.List;

public interface WaterLogService {

    WaterResponse addWater(
            WaterRequest request
    );

    List<WaterResponse> getTodayWater();

    List<WaterResponse> getHistory();

    void deleteWater(
            Long id
    );
}
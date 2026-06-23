package com.shravan.backend.service;

import com.shravan.backend.dto.WeightLogRequest;
import com.shravan.backend.dto.WeightLogResponse;

import java.util.List;

public interface WeightLogService {

    WeightLogResponse addWeightLog(
            WeightLogRequest request
    );

    List<WeightLogResponse> getWeightLogs();

    WeightLogResponse getLatestWeight();
}
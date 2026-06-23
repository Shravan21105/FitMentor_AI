package com.shravan.backend.service;

import com.shravan.backend.dto.WeightLogRequest;
import com.shravan.backend.dto.WeightLogResponse;
import com.shravan.backend.entity.User;
import com.shravan.backend.entity.WeightLog;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.repository.WeightLogRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeightLogServiceImpl
        implements WeightLogService {

    private final WeightLogRepository weightLogRepository;
    private final UserRepository userRepository;

    @Override
    public WeightLogResponse addWeightLog(
            WeightLogRequest request
    ) {

        String email = SecurityUtils.getCurrentUserEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        WeightLog weightLog = WeightLog.builder()
                .weight(request.getWeight())
                .notes(request.getNotes())
                .loggedDate(LocalDate.now())
                .user(user)
                .build();

        weightLogRepository.save(weightLog);

        return mapToResponse(weightLog);
    }

    @Override
    public List<WeightLogResponse> getWeightLogs() {

        String email = SecurityUtils.getCurrentUserEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return weightLogRepository
                .findByUserOrderByLoggedDateDesc(user)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public WeightLogResponse getLatestWeight() {

        String email = SecurityUtils.getCurrentUserEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        List<WeightLog> logs =
                weightLogRepository.findByUserOrderByLoggedDateDesc(user);

        if(logs.isEmpty()) {
            throw new RuntimeException("No weight logs found");
        }

        return mapToResponse(logs.get(0));
    }

    private WeightLogResponse mapToResponse(
            WeightLog weightLog
    ) {
        return WeightLogResponse.builder()
                .id(weightLog.getId())
                .weight(weightLog.getWeight())
                .loggedDate(weightLog.getLoggedDate())
                .notes(weightLog.getNotes())
                .build();
    }
}
package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class WaterResponse {

    private Long id;

    private Integer amount;

    private LocalDate loggedDate;

    private LocalDateTime loggedAt;
}
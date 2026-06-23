package com.shravan.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class WeightLogResponse {

    private Long id;

    private Double weight;

    private LocalDate loggedDate;

    private String notes;
}
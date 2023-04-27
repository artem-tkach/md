package io.skai.accounting.dto.repair;

import io.skai.accounting.enums.RepairResult;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record RepairRequestDto(
        @NotNull
        Long orderId,
        @NotNull
        Long masterId,
        @NotNull
        RepairResult result,
        @NotNull
        Double sum,
        Map<Long, Integer> components,
        String comment) {
}
package io.skai.accounting.dto.repair;

import io.skai.accounting.enums.RepairResult;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Map;

import static io.skai.accounting.util.ValidationMessages.*;

public record RepairRequestDto(
        @Positive(message = WRONG_ORDER_ID)
        @NotNull(message = NULL_ORDER_ID)
        Long orderId,
        @Positive(message = WRONG_MASTER_ID)
        @NotNull(message = NULL_MASTER_ID)
        Long masterId,
        @NotBlank(message = BLANK_REPAIR_RESULT)
        RepairResult result,
        Double sum,
        Map<Long, Integer> components,
        String comment) {
}
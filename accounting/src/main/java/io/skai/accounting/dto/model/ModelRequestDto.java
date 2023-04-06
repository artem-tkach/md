package io.skai.accounting.dto.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static io.skai.accounting.util.ValidationMessages.*;

public record ModelRequestDto(
        @NotNull(message = NULL_BRAND_ID)
        Long brandId,
        @NotNull(message = NULL_MODEL_NAME)
        @Size(min = 1, message = SHORT_NAME)
        String name) {
}

package io.skai.accounting.dto.brand;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static io.skai.accounting.util.ValidationMessages.NULL_BRAND_NAME;
import static io.skai.accounting.util.ValidationMessages.SHORT_NAME;

public record BrandRequestDto(@NotNull(message = NULL_BRAND_NAME)
                              @Size(min = 1, message = SHORT_NAME)
                              String name) {
}

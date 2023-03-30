package io.skai.accounting.dto.brand;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static io.skai.accounting.util.ValidationMessages.NULL_BRAND_NAME;
import static io.skai.accounting.util.ValidationMessages.SHORT_NAME;

@Value
@Builder
@Jacksonized
public class BrandRequestDto {
    @NotNull(message = NULL_BRAND_NAME)
    @Size(min = 1, message = SHORT_NAME)
    String name;
}

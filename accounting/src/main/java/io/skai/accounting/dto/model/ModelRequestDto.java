package io.skai.accounting.dto.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static io.skai.accounting.util.ValidationMessages.NULL_BRAND_ID;
import static io.skai.accounting.util.ValidationMessages.NULL_MODEL_NAME;
import static io.skai.accounting.util.ValidationMessages.SHORT_NAME;

@Value
@Builder
@Jacksonized
public class ModelRequestDto {
    @NotNull(message = NULL_BRAND_ID)
    Long brandId;
    @NotNull(message = NULL_MODEL_NAME)
    @Size(min = 1, message = SHORT_NAME)
    String name;
}

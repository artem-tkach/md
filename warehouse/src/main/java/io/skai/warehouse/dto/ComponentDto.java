package io.skai.warehouse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ComponentDto(Long id,
                           @NotBlank
                           String name,
                           @NotNull
                           Double count,
                           @NotNull
                           Double reserved) {
}
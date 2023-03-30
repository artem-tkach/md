package io.skai.accounting.dto.model;

import io.skai.accounting.dto.brand.BrandResponseDto;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ModelResponseDto {
    Long id;
    String name;
    BrandResponseDto brand;
}

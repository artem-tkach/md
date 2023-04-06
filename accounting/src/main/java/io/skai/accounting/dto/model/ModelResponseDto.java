package io.skai.accounting.dto.model;

import io.skai.accounting.dto.brand.BrandResponseDto;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ModelResponseDto {
    //TODO rename into ModelDto
    //TODO rename package with out camelCase
    Long id;
    String name;
    BrandResponseDto brand;
}

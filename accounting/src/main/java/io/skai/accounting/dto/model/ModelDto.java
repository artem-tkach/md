package io.skai.accounting.dto.model;

import io.skai.accounting.dto.brand.BrandDto;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ModelDto {
    Long id;
    String name;
    BrandDto brand;
}

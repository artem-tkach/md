package io.skai.accounting.dto.brand;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class BrandResponseDto {
    Long id;
    String name;
}

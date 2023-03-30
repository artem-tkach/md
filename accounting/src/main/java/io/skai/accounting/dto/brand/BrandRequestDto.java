package io.skai.accounting.dto.brand;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
@Value
@Builder
@Jacksonized
public class BrandRequestDto {
    String name;
}

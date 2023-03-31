package io.skai.accounting.dto.client;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ClientResponseDto {
    Long id;
    String name;
    String email;
}

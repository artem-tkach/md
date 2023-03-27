package io.skai.accounting.dto.user;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;


@Jacksonized
@Builder
@Value
public class UserResponseDto {
    Long id;
    String name;
}

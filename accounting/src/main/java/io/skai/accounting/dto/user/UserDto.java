package io.skai.accounting.dto.user;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;


@Jacksonized
@Builder
@Value
public class UserDto {
    Long id;
    String name;
}

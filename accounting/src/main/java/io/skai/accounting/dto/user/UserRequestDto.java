package io.skai.accounting.dto.user;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UserRequestDto {
    String name;
}

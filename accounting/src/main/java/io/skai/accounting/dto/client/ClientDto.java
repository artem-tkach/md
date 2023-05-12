package io.skai.accounting.dto.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@Jacksonized
public class ClientDto {
    Long id;
    String name;
    String email;
}
package io.skai.accounting.dto.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ClientDto {
    Long id;
    String name;
    String email;
}
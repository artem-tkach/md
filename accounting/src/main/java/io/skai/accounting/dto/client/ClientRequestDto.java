package io.skai.accounting.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static io.skai.accounting.util.ValidationMessages.*;

@Value
@Builder
@Jacksonized
public class ClientRequestDto {
    @NotNull(message = NULL_CLIENT_NAME)
    @Size(min = 1, message = SHORT_NAME)
    String name;
    @NotBlank(message = BLANK_EMAIL)
    @Email(message = WRONG_EMAIL)
    String email;
}

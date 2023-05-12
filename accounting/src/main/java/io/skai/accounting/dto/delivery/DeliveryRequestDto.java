package io.skai.accounting.dto.delivery;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import static io.skai.accounting.util.ValidationMessages.NULL_ORDER_ID;
import static io.skai.accounting.util.ValidationMessages.WRONG_ORDER_ID;

public record DeliveryRequestDto(
        @Positive(message = WRONG_ORDER_ID)
        @NotNull(message = NULL_ORDER_ID)
        Long orderId,

        @Positive
        @NotNull
        Long managerId,
        Double sum,
        String guid) {
}
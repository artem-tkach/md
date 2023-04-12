package io.skai.notification.dto.template;

import io.skai.notification.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static io.skai.notification.util.ValidationMessages.*;


public record TemplateRequestDto(@NotNull(message = NULL_ORDER_STATUS)
                                 OrderStatus status,
                                 @NotBlank(message = BLANK_TEMPLATE_BODY)
                                 String body,
                                 @NotBlank(message = BLANK_SUBJECT)
                                 String subjectText) {
}
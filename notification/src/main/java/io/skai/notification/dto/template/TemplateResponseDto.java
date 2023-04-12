package io.skai.notification.dto.template;

import io.skai.notification.enums.OrderStatus;

public record TemplateResponseDto(Long id,
                                  OrderStatus status,
                                  String body,
                                  String subject) {
}
package io.skai.notification.service;

import io.skai.notification.dto.template.TemplateRequestDto;
import io.skai.notification.dto.template.TemplateResponseDto;
import io.skai.notification.enums.OrderStatus;

import java.util.List;

public interface TemplateService {
    TemplateResponseDto create(TemplateRequestDto dto);

    List<TemplateResponseDto>getAll();

    List<TemplateResponseDto> getAll(OrderStatus orderStatus);
}

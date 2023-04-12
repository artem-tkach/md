package io.skai.notification.service.impl;

import io.skai.notification.dto.template.TemplateRequestDto;
import io.skai.notification.dto.template.TemplateResponseDto;
import io.skai.notification.enums.OrderStatus;
import io.skai.notification.mappers.TemplateMapper;
import io.skai.notification.model.Template;
import io.skai.notification.repository.TemplateRepository;
import io.skai.notification.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final TemplateMapper templateMapper;
    private final TemplateRepository templateRepository;

    @Override
    public TemplateResponseDto create(TemplateRequestDto dto) {
        Template template = templateMapper.toTemplate(dto);
        return templateMapper.toResponseDto(
                templateRepository.save(template));
    }

    @Override
    public List<TemplateResponseDto> getAll() {
        return templateMapper.toResponseDtoList(
                templateRepository.findAll());
    }

    @Override
    public List<TemplateResponseDto> getAll(OrderStatus orderStatus) {
        return templateMapper.toResponseDtoList(
                templateRepository.findAllByStatus(orderStatus));
    }

}
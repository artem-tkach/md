package io.skai.accounting.service;

import io.skai.accounting.dto.model.ModelRequestDto;
import io.skai.accounting.dto.model.ModelResponseDto;

import java.util.List;

public interface ModelService {
    ModelResponseDto create(ModelRequestDto dto);

    List<ModelResponseDto> findAllDto(Long brandId);
}

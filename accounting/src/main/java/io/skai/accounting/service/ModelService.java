package io.skai.accounting.service;

import io.skai.accounting.dto.model.ModelInfoDto;
import io.skai.accounting.dto.model.ModelRequestDto;
import io.skai.accounting.dto.model.ModelDto;

import java.util.List;

public interface ModelService {
    ModelDto create(ModelRequestDto dto);

    List<ModelDto> findAllDto(Long brandId);

    ModelInfoDto finModelInfoDto(Long id);
}

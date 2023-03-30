package io.skai.accounting.service;

import io.skai.accounting.dto.model.ModelRequestDto;
import io.skai.accounting.dto.model.ModelResponseDto;
import io.skai.accounting.jooq.tables.pojos.Model;

import java.util.List;

public interface ModelService {
    ModelResponseDto create(final ModelRequestDto dto);
    List<ModelResponseDto> findAllDtoByBrandId(final Long brandId);
    List<Model> findAllByBrandId(final Long brandId);

}

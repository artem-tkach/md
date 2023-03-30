package io.skai.accounting.service;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;

import java.util.List;

public interface BrandService {
    BrandResponseDto create(BrandRequestDto dto);

    List<BrandResponseDto> getAll();
}

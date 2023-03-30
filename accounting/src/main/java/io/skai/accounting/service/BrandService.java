package io.skai.accounting.service;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    BrandResponseDto create(BrandRequestDto dto);

    List<BrandResponseDto> getAll();

    Optional<Brand> findById(Long id);
}

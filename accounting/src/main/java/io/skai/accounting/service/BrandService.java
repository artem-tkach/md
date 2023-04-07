package io.skai.accounting.service;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandDto;
import io.skai.accounting.jooq.tables.pojos.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    BrandDto create(BrandRequestDto dto);

    List<BrandDto> getAll();

    Optional<Brand> findOptional(Long id);

    Brand findOne(Long id);
}

package io.skai.accounting.service.impl;

import io.skai.accounting.dto.brand.BrandDto;
import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.mappers.BrandMapper;
import io.skai.accounting.repository.BrandRepository;
import io.skai.accounting.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;
    private final BrandRepository brandRepository;

    @Override
    @Cacheable("brand")
    public BrandDto create(BrandRequestDto dto) {
        return brandMapper.toBrandResponseDto(brandRepository.create(dto.name()));
    }

    @Override
    public List<BrandDto> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brandMapper.toBrandDtoList(brands);
    }

    @Override
    @Cacheable(value = "brand")
    public Brand findOne(Long id) {
        log.trace("Call find brand by id, id={}", id);
        return brandRepository.findOne(id);
    }
}
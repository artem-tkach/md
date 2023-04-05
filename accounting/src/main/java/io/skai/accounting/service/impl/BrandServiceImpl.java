package io.skai.accounting.service.impl;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.mappers.BrandMapper;
import io.skai.accounting.repository.BrandRepository;
import io.skai.accounting.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class BrandServiceImpl implements BrandService {
    private final BrandMapper brandMapper;
    private final BrandRepository brandRepository;

    @Override
    @CacheEvict("brand")
    public BrandResponseDto create(BrandRequestDto dto) {
        //Todo::Cache evict doesn't works
        log.trace("Call create brand");
        return brandMapper.toBrandResponseDto(brandRepository.create(dto.getName()));
    }

    @Override
    public List<BrandResponseDto> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brandMapper.toBrandResponseDtoList(brands);
    }

    @Override
    public Optional<Brand> findOptional(Long id) {
        log.trace("Call find optional<Brand> by id, id={}", id);
        return brandRepository.findOneOptional(id);
    }

    @Override
    @Cacheable(value = "brand")
    public Brand findOne(Long id) {
        //TODO::look memoization
        log.trace("Call find brand by id, id={}", id);
        return brandRepository.findOne(id);
    }
}

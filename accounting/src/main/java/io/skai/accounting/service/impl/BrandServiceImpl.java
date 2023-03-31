package io.skai.accounting.service.impl;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.mappers.BrandMapper;
import io.skai.accounting.repo.BrandRepo;
import io.skai.accounting.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class BrandServiceImpl implements BrandService {
    private final BrandMapper brandMapper;
    private final BrandRepo brandRepo;

    @Override
    public BrandResponseDto create(final BrandRequestDto dto) {
        log.trace("Call create brand");
        return brandMapper.toBrandResponseDto(brandRepo.create(dto.getName()));
    }

    @Override
    public List<BrandResponseDto> getAll() {
        List<Brand> brands = brandRepo.findAll();
        return brandMapper.toBrandResponseDtoList(brands);
    }

    @Override
    public Optional<Brand> findOptionalById(final Long id) {
        log.trace("Call find optional<Brand> by id, id={}", id);
        return brandRepo.findOneOptional(id);
    }

    @Override
    public Brand findById(final Long id) {
        log.trace("Call find brand by id, id={}", id);
        return brandRepo.findOne(id);
    }
}

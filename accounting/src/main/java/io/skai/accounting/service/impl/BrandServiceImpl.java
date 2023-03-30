package io.skai.accounting.service.impl;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.jooq.Tables;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.records.BrandRecord;
import io.skai.accounting.mappers.BrandMapper;
import io.skai.accounting.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.skai.accounting.jooq.Tables.BRAND;

@Service
@RequiredArgsConstructor
@Log4j2
public class BrandServiceImpl implements BrandService {
    private final DSLContext dslContext;
    private final BrandMapper brandMapper;
    @Override
    public BrandResponseDto create(BrandRequestDto dto) {
        log.trace("Call create brand");
        BrandRecord brandRecord = dslContext.insertInto(BRAND)
                .columns(BRAND.NAME)
                .values(dto.getName())
                .returning()
                .fetchOne();

        return brandMapper.totoBrandResponseDto(brandRecord);
    }

    @Override
    public List<BrandResponseDto> getAll() {
        List<Brand> brands = dslContext.selectFrom(BRAND)
                .fetchInto(Brand.class);
        return brandMapper.toBrandResponseDtoList(brands);
    }

    @Override
    public Optional<Brand> findById(Long id) {
        log.trace("Call find brand by id, id={id}", id);
        return dslContext.selectFrom(BRAND)
                .where(BRAND.ID.eq(id))
                .fetchOptionalInto(Brand.class);
    }
}

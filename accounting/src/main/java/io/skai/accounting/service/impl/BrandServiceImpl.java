package io.skai.accounting.service.impl;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.jooq.Tables;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.mappers.BrandMapper;
import io.skai.accounting.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BrandServiceImpl implements BrandService {
    private final DSLContext dslContext;
    private final BrandMapper brandMapper;
    @Override
    public BrandResponseDto create(BrandRequestDto dto) {

        dslContext.insertInto(Tables.BRAND)
                .columns(Tables.BRAND.NAME)
                .values(dto.getName())
                .execute();


        return null;
    }

    @Override
    public List<BrandResponseDto> getAll() {
        List<Brand> brands = dslContext.selectFrom(Tables.BRAND)
                .fetchInto(Brand.class);
        return brandMapper.toBrandResponseDtoList(brands);
    }
}

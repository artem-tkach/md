package io.skai.accounting.mappers;

import io.skai.accounting.dto.brand.BrandDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    List<BrandDto> toBrandResponseDtoList(List<Brand> brands);

    BrandDto toBrandResponseDto(Brand brand);

}

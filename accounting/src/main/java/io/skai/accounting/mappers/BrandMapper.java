package io.skai.accounting.mappers;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface BrandMapper {
    List<BrandResponseDto> toBrandResponseDtoList(List<Brand> brands);

    @Mapping(target = "id", ignore = true)
    Brand toBrand(BrandRequestDto dto);

    BrandResponseDto toBrandResponseDto(Brand brand);

}

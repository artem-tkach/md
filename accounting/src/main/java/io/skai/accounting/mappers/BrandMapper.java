package io.skai.accounting.mappers;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    List<BrandResponseDto> toBrandResponseDtoList(List<Brand> brands);

    Brand toBrand(BrandRequestDto dto);

}

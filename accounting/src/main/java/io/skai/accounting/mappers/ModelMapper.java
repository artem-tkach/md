package io.skai.accounting.mappers;

import io.skai.accounting.dto.model.ModelResponseDto;
import io.skai.accounting.jooq.tables.pojos.Model;
import io.skai.accounting.service.BrandService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {BrandMapper.class, BrandService.class})
public interface ModelMapper {
    @Mapping(source = "brandId", target = "brand")
    ModelResponseDto toModelResponseDto(Model model);
    @Mapping(source = "brandId", target = "brand")
    List<ModelResponseDto> toModelResponseDtoList(List<Model> models);
}

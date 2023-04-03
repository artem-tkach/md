package io.skai.accounting.mappers;

import io.skai.accounting.dto.model.ModelResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.pojos.Model;
import io.skai.accounting.service.BrandService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {BrandMapper.class, BrandService.class})
public interface ModelMapper {
    @Mapping(source = "brandId", target = "brand")
    ModelResponseDto toModelResponseDto(Model model);
    @Mapping(source = "brandId", target = "brand")
    List<ModelResponseDto> toModelResponseDtoList(List<Model> models);
    @Mapping(target = "id", source = "model.id")
    @Mapping(target = "name", source = "model.name")
    ModelResponseDto toModelResponseDto(Model model, Brand brand);

}

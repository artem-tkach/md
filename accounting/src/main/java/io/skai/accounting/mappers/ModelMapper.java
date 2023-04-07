package io.skai.accounting.mappers;

import io.skai.accounting.dto.model.ModelDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.pojos.Model;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {BrandMapper.class})
public interface ModelMapper {

    @Mapping(target = "id", source = "model.id")
    @Mapping(target = "name", source = "model.name")
    ModelDto toModelDto(Model model, Brand brand);
}

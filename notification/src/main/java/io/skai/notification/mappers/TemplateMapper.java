package io.skai.notification.mappers;

import io.skai.notification.dto.template.TemplateRequestDto;
import io.skai.notification.dto.template.TemplateResponseDto;
import io.skai.notification.model.Template;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TemplateMapper {

    @Mapping(target = "id", ignore = true)
    Template toTemplate(TemplateRequestDto dto);

    TemplateResponseDto toResponseDto(Template template);
}

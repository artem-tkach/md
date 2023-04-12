package io.skai.notification.mappers;

import io.skai.notification.dto.template.TemplateRequestDto;
import io.skai.notification.dto.template.TemplateResponseDto;
import io.skai.notification.enums.OrderStatus;
import io.skai.notification.model.Template;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateMapperTest {
    private final TemplateMapper MAPPER = Mappers.getMapper(TemplateMapper.class);
    private final TemplateRequestDto REQUEST_DTO = new TemplateRequestDto(OrderStatus.NEW, "body text", "subject text");

    @Test
    void whenRequestDtoIsPresentMapToTemplateThenReturn() {
        Template expected = new Template(null, OrderStatus.NEW, "body text", "subject text");
        Template result = MAPPER.toTemplate(REQUEST_DTO);

        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void whenRequestDtoIsNullThenReturnNull() {
        assertThat(MAPPER.toTemplate(null))
                .isNull();
    }

    @Test
    void whenTemplateIsPresentThenMapToResponseDtoAndReturn() {
        Template template = new Template(328L, OrderStatus.NEW, "body text", "subject text");
        TemplateResponseDto expected = new TemplateResponseDto(328L, OrderStatus.NEW, "body text", "subject text");
        TemplateResponseDto result = MAPPER.toResponseDto(template);

        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void whenTemplateIsNullThenReturnNull() {
        assertThat(MAPPER.toResponseDto(null))
                .isNull();
    }
}
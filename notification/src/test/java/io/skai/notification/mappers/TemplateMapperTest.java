package io.skai.notification.mappers;

import io.skai.notification.dto.template.TemplateRequestDto;
import io.skai.notification.dto.template.TemplateResponseDto;
import io.skai.notification.enums.OrderStatus;
import io.skai.notification.model.Template;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateMapperTest {
    private static final TemplateRequestDto REQUEST_DTO_NEW = new TemplateRequestDto(OrderStatus.NEW, "body text new", "subject text new");
    private static final Template TEMPLATE_NEW = new Template(328L, OrderStatus.NEW, "body text new", "subject text new");
    private static final Template TEMPLATE_CANCELED = new Template(487L, OrderStatus.CANCELED, "body text canceled", "subject text canceled");
    private static final TemplateResponseDto RESPONSE_DTO_NEW = new TemplateResponseDto(328L, OrderStatus.NEW, "body text new", "subject text new");
    private static final TemplateResponseDto RESPONSE_DTO_CANCELED = new TemplateResponseDto(487L, OrderStatus.CANCELED, "body text canceled", "subject text canceled");
    private final static TemplateMapper MAPPER = Mappers.getMapper(TemplateMapper.class);

    @Test
    void whenRequestDtoIsPresentMapToTemplateThenReturn() {
        Template expected = new Template(null, OrderStatus.NEW, "body text new", "subject text new");
        Template result = MAPPER.toTemplate(REQUEST_DTO_NEW);

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
        TemplateResponseDto result = MAPPER.toResponseDto(TEMPLATE_NEW);

        assertThat(result)
                .isEqualTo(RESPONSE_DTO_NEW);
    }

    @Test
    void whenTemplateIsNullThenReturnNull() {
        assertThat(MAPPER.toResponseDto(null))
                .isNull();
    }

    @Test
    void whenTemplateListIsNullThenReturnNull() {
        assertThat(MAPPER.toResponseDtoList(null))
                .isNull();
    }

    @Test
    void whenTemplateListIsPresentThenMapAndReturn() {
        List<Template> templates = List.of(TEMPLATE_NEW, TEMPLATE_CANCELED);

        List<TemplateResponseDto> result = MAPPER.toResponseDtoList(templates);
        assertThat(result)
                .containsExactlyInAnyOrder(RESPONSE_DTO_CANCELED, RESPONSE_DTO_NEW);
    }
}
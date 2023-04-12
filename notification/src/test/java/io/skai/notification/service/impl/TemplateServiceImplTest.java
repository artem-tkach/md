package io.skai.notification.service.impl;

import io.skai.notification.dto.template.TemplateRequestDto;
import io.skai.notification.dto.template.TemplateResponseDto;
import io.skai.notification.enums.OrderStatus;
import io.skai.notification.mappers.TemplateMapper;
import io.skai.notification.model.Template;
import io.skai.notification.repository.TemplateRepository;
import io.skai.notification.service.TemplateService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TemplateServiceImplTest {

    private static final TemplateRequestDto REQUEST_DTO_NEW = new TemplateRequestDto(OrderStatus.NEW, "body text new", "subject text new");
    private static final Template TEMPLATE_NEW = new Template(328L, OrderStatus.NEW, "body text new", "subject text new");
    private static final Template TEMPLATE_CANCELED = new Template(487L, OrderStatus.CANCELED, "body text canceled", "subject text canceled");
    private static final TemplateResponseDto RESPONSE_DTO_NEW = new TemplateResponseDto(328L, OrderStatus.NEW, "body text new", "subject text new");
    private static final TemplateResponseDto RESPONSE_DTO_CANCELED = new TemplateResponseDto(487L, OrderStatus.CANCELED, "body text canceled", "subject text canceled");


    private final TemplateRepository repository = mock(TemplateRepository.class);
    private  final TemplateMapper mapper = mock(TemplateMapper.class);
    private  final TemplateService service= new TemplateServiceImpl(mapper, repository);

    @Test
    void whenEntityNotInDbCreateThenReturn(){
        when(repository.save(any(Template.class)))
                .thenReturn(TEMPLATE_NEW);
        when(mapper.toTemplate(REQUEST_DTO_NEW))
                .thenReturn(TEMPLATE_NEW);
        when(mapper.toResponseDto(TEMPLATE_NEW))
                .thenReturn(RESPONSE_DTO_NEW);

        TemplateResponseDto result = service.create(REQUEST_DTO_NEW);

        verify(repository)
                .save(TEMPLATE_NEW);
        verifyNoMoreInteractions(repository);
        assertThat(result)
                .isEqualTo(RESPONSE_DTO_NEW);
    }

    @Test
    void whenDataInDBThenReturnItAll(){
        List<Template> templatesInBase = List.of(TEMPLATE_NEW, TEMPLATE_CANCELED);
        when(repository.findAll())
                .thenReturn(templatesInBase);
        when(mapper.toResponseDtoList(templatesInBase))
                .thenReturn(List.of(RESPONSE_DTO_NEW, RESPONSE_DTO_CANCELED));

        List<TemplateResponseDto> result = service.getAll();

        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
        assertThat(result)
                .containsExactlyInAnyOrder(RESPONSE_DTO_CANCELED, RESPONSE_DTO_NEW);
    }

    @Test
    void whenDataInDBThenReturnItByOrderStatus(){
        List<Template> templatesInBase = List.of(TEMPLATE_NEW);

        when(repository.findAllByStatus(OrderStatus.NEW))
                .thenReturn(templatesInBase);

        when(mapper.toResponseDtoList(templatesInBase))
                .thenReturn(List.of(RESPONSE_DTO_NEW));

        List<TemplateResponseDto> result = service.getAll(OrderStatus.NEW);

        verify(repository).findAllByStatus(OrderStatus.NEW);
        verifyNoMoreInteractions(repository);
        assertThat(result)
                .containsExactlyInAnyOrder(RESPONSE_DTO_NEW);
    }
}
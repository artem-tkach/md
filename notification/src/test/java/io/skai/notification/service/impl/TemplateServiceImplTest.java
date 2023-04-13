package io.skai.notification.service.impl;

import io.skai.notification.enums.OrderStatus;
import io.skai.notification.model.Template;
import io.skai.notification.repository.TemplateRepository;
import io.skai.notification.service.TemplateService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TemplateServiceImplTest {

    private static final Template TEMPLATE_TO_CREATE = new Template(null,OrderStatus.NEW, "body text new", "subject text new");
    private static final Template TEMPLATE_NEW = new Template(328L, OrderStatus.NEW, "body text new", "subject text new");
    private static final Template TEMPLATE_CANCELED = new Template(487L, OrderStatus.CANCELED, "body text canceled", "subject text canceled");

    private final TemplateRepository repository = mock(TemplateRepository.class);
    private  final TemplateService service= new TemplateServiceImpl(repository);

    @Test
    void shouldCreateAndReturnNewTemplate(){
        when(repository.save(TEMPLATE_TO_CREATE)).thenReturn(TEMPLATE_NEW);

        Template result = service.create(TEMPLATE_TO_CREATE);

        verify(repository).save(TEMPLATE_TO_CREATE);
        verifyNoMoreInteractions(repository);
        assertThat(result).isEqualTo(TEMPLATE_NEW);
    }

    @Test
    void shouldGetAllTemplatesAndReturn(){
        List<Template> templatesInBase = List.of(TEMPLATE_NEW, TEMPLATE_CANCELED);
        when(repository.findAll())
                .thenReturn(templatesInBase);

        List<Template> result = service.getAll();

        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
        assertThat(result)
                .containsExactlyInAnyOrder(TEMPLATE_CANCELED, TEMPLATE_NEW);
    }

    @Test
    void whenDataInDBThenReturnItByOrderStatus(){
        List<Template> templatesInBase = List.of(TEMPLATE_NEW);

        when(repository.findAllByStatus(OrderStatus.NEW))
                .thenReturn(templatesInBase);

        List<Template> result = service.getAll(OrderStatus.NEW);

        verify(repository).findAllByStatus(OrderStatus.NEW);
        verifyNoMoreInteractions(repository);
        assertThat(result)
                .containsExactlyInAnyOrder(TEMPLATE_NEW);
    }
}
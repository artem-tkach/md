package io.skai.warehouse.service.impl;

import io.skai.warehouse.model.component.Component;
import io.skai.warehouse.repository.ComponentPersistence;
import io.skai.warehouse.service.ComponentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class ComponentServiceCacheTest {

    private static final Long ID = 1L;

    private static final Component EXPECTED = new Component(ID, "screen", 15d, 10d);

    @Autowired
    private ComponentService componentService;

    @MockBean
    private ComponentPersistence componentPersistence;

    @Test
    void shouldReadDBOnlyOnce() {
        when(componentPersistence.find(ID)).thenReturn(EXPECTED);

        componentService.findById(ID);
        Component fromCache = componentService.findById(ID);

        assertThat(fromCache).isEqualTo(EXPECTED);
    }

    @Test
    void shouldGetComponentFromCache() {
        when(componentPersistence.find(ID)).thenReturn(EXPECTED);

        componentService.findById(ID);
        componentService.findById(ID);

        verify(componentPersistence, atMost(1)).find(ID);
    }
}
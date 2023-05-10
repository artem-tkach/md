package io.skai.warehouse.service.impl;

import io.skai.warehouse.cache.ComponentCacheStore;
import io.skai.warehouse.model.component.Component;
import io.skai.warehouse.repository.ComponentPersistence;
import io.skai.warehouse.service.ComponentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

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

    @Autowired
    private ComponentCacheStore cacheStore;

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

    @Test
    void shouldInvalidateCacheWhenUpdateSuccessful(){
        when(componentPersistence.find(ID)).thenReturn(EXPECTED);
        when(componentPersistence.insertOnDuplicateUpdate(any())).thenReturn(null);

        componentService.findById(ID);
        assertThat(cacheStore.size()).isEqualTo(1L);
        componentService.updateResidues(Map.of(ID, 0d));
        assertThat(cacheStore.size()).isZero();
    }

    @Test
    void shouldNotInvalidateCacheWhenUpdateFails(){
        when(componentPersistence.find(ID)).thenReturn(EXPECTED);
        when(componentPersistence.insertOnDuplicateUpdate(any())).thenReturn(null);

        componentService.findById(ID);
        assertThat(cacheStore.size()).isEqualTo(1L);
        componentService.updateResidues(Map.of(ID, 999d));
        assertThat(cacheStore.size()).isEqualTo(1L);
    }
}
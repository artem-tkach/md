package io.skai.accounting.service.impl;

import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.repository.BrandRepository;
import io.skai.accounting.service.BrandService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class BrandServiceImplCacheTest {
    private final Brand IPHONE = new Brand(1L, "iPhone");

    @MockBean
    private BrandRepository brandRepository;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CacheManager cacheManager;

    @Test
    void whenDataInsertedGetEntityTwiceThenReturnItFromCache(){
        when(brandRepository.find(IPHONE.getId()))
                .thenReturn(IPHONE);

        Brand resultBrand1 = brandService.find(IPHONE.getId());
        Brand resultBrand2 = brandService.find(IPHONE.getId());

        verify(brandRepository,atMost(1))
                .find(IPHONE.getId());
        assertThat(resultBrand1)
                .isEqualTo(resultBrand2);
    }
    @AfterEach
    void clearCache(){
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(n -> Objects.requireNonNull(cacheManager.getCache(n)).clear());
    }

}

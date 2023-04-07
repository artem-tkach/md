package io.skai.accounting.service.impl;

import io.skai.accounting.dto.brand.BrandDto;
import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.repository.BrandRepository;
import io.skai.accounting.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@SpringBootTest
class BrandServiceImplTest {
    @MockBean
    private BrandRepository brandRepository;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CacheManager cacheManager;


    private Optional<Brand> getCachedBrand(Long id) {
        return ofNullable(cacheManager.getCache("brand"))
                .map(c -> c.get(id, Brand.class));
    }

    @Test
    void whenDataMockedFindAllThenReturnIt() {
        List<Brand> brands = List.of(new Brand(1L, "iPhone"),
                new Brand(2L, "Samsung"));
        when(brandRepository.findAll())
                .thenReturn(brands);
        List<BrandDto> result = brandService.getAll();
        verify(brandRepository, times(1)).findAll();

        assertThat(result)
                .hasSize(2)
                .extracting(BrandDto::getName)
                .contains("Samsung", "iPhone")
                .doesNotContainNull()
                .doesNotContain("xiaomi");
    }

    @Test
    void whenCalledFindOneThenGetCacheAndReturnIt() {
        when(brandRepository.findOne(anyLong()))
                .thenReturn(new Brand(1L, "iPhone"));
        brandService.findOne(1L);
        Optional<Brand> cachedBrand = getCachedBrand(1L);
        assertThat(cachedBrand)
                .isPresent()
                .satisfies(value -> assertThat(value.orElseThrow())
                        .hasFieldOrPropertyWithValue("id", 1L)
                        .hasFieldOrPropertyWithValue("name", "iPhone"));
    }

    @Test
    void whenFindOneNotCalledThenCacheIsEmpty() {
        Optional<Brand> cachedBrand = getCachedBrand(999L);
        assertThat(cachedBrand)
                .isEmpty();
    }

    @Test
    void whenNoSuchBrandInDBCreateBrandThenReturnDto() {
        ReflectionTestUtils.setField(brandService, "brandRepository", brandRepository);
        String testBrandName = "Xiaomi";
        Brand brand = new Brand(1L, testBrandName);
        doReturn(brand)
                .when(brandRepository).create(testBrandName);
        BrandRequestDto requestDto = new BrandRequestDto(testBrandName);
        BrandDto resultDto = brandService.create(requestDto);
        verify(brandRepository, times(1))
                .create(testBrandName);
        assertThat(resultDto)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", testBrandName);
    }

    @Test
    void whenBrandExistsInDBCreateBrandThenThrowException() {
        ReflectionTestUtils.setField(brandService, "brandRepository", brandRepository);
        String testBrandName = "Xiaomi999";
        doThrow(DuplicateKeyException.class)
                .when(brandRepository).create(testBrandName);
        BrandRequestDto requestDto = new BrandRequestDto(testBrandName);
        verify(brandRepository, times(1)).create(testBrandName);
        assertThatThrownBy(() -> brandService.create(requestDto)).
                isInstanceOf(DuplicateKeyException.class);
    }

    @Test
    void whenDataInsertedFindThenReturnIt(){
        ReflectionTestUtils.setField(brandService, "brandRepository", brandRepository);
        String testBrandName = "Xiaomi";
        Brand brand = new Brand(333L, testBrandName);
        doReturn(brand)
                .when(brandRepository).findOne(333L);
        Brand resultBrand = brandService.findOne(333L);
        verify(brandRepository, times(1)).findOne(333L);
        assertThat(resultBrand)
                .hasFieldOrPropertyWithValue("id",333L)
                .hasFieldOrPropertyWithValue("name","Xiaomi");
    }
}
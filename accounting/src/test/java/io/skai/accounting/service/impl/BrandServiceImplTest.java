package io.skai.accounting.service.impl;

import io.skai.accounting.dto.brand.BrandDto;
import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.mappers.BrandMapper;
import io.skai.accounting.repository.BrandRepository;
import io.skai.accounting.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

class BrandServiceImplTest {
    private final Brand XIAOMI = new Brand(1L, "Xiaomi");
    private final Brand SAMSUNG = new Brand(2L, "SAMSUNG");
    private final BrandDto XIAOMI_DTO = BrandDto.builder().id(1L).name("Xiaomi").build();
    private final BrandDto SAMSUNG_DTO = BrandDto.builder().id(2L).name("SAMSUNG").build();
    private final BrandRequestDto XIAOMI_REQUEST_DTO = new BrandRequestDto(XIAOMI.getName());

    private final BrandRepository brandRepository = mock(BrandRepository.class);
    private final BrandMapper brandMapper = mock(BrandMapper.class);
    private final BrandService brandService = new BrandServiceImpl(brandMapper,brandRepository);

    @Test
    void whenNoSuchBrandInDBCreateBrandThenReturnDto() {
        BrandDto mockResponse = BrandDto.builder().id(XIAOMI.getId()).name(XIAOMI.getName()).build();

        doReturn(XIAOMI)
                .when(brandRepository).create(XIAOMI.getName());
        doReturn(mockResponse)
                .when(brandMapper).toBrandResponseDto(XIAOMI);

        BrandDto resultDto = brandService.create(XIAOMI_REQUEST_DTO);

        verify(brandRepository).create(XIAOMI.getName());
        assertThat(resultDto)
                .isEqualTo(mockResponse);
    }

    @Test
    void whenBrandExistsInDBCreateBrandThenThrowException() {
        String testBrandName = "Xiaomi999";
        doThrow(DuplicateKeyException.class)
                .when(brandRepository).create(testBrandName);
        BrandRequestDto requestDto = new BrandRequestDto(testBrandName);

        assertThatThrownBy(() -> brandService.create(requestDto)).
                isInstanceOf(DuplicateKeyException.class);
        verify(brandRepository).create(testBrandName);
    }

    @Test
    void whenDataInsertedFindThenReturnIt(){
        doReturn(XIAOMI)
                .when(brandRepository).findOne(XIAOMI.getId());
        Brand resultBrand = brandService.findOne(XIAOMI.getId());

        verify(brandRepository).findOne(XIAOMI.getId());
        assertThat(resultBrand)
                .isEqualTo(XIAOMI);
    }
    @Test
    void whenBrandsInDbGetWhamAndReturn(){
        List<Brand> brands = List.of(XIAOMI, SAMSUNG);
        List<BrandDto> brandDtos = List.of(XIAOMI_DTO, SAMSUNG_DTO);
        when(brandRepository.findAll()).thenReturn(brands);
        when(brandMapper.toBrandDtoList(brands))
                .thenReturn(brandDtos);

        List<BrandDto> result = brandService.getAll();
        assertThat(result).containsExactlyInAnyOrder(SAMSUNG_DTO, XIAOMI_DTO);
    }

}

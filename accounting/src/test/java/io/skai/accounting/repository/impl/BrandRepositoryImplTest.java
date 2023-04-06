package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.Tables;
import io.skai.accounting.jooq.tables.pojos.Brand;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static io.skai.accounting.jooq.Tables.BRAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
class BrandRepositoryImplTest {
    @Autowired
    private BrandRepositoryImpl brandRepository;
    @Autowired
    private DSLContext dslContext;


    @BeforeEach
    void prepareTable() {
        clearTableBrand();
        addTestRecords();
    }

    private void clearTableBrand() {
        dslContext
                .truncate(Tables.BRAND)
                .execute();
    }

    private void addTestRecords() {
        dslContext.insertInto(BRAND, BRAND.ID, BRAND.NAME)
                .values(1L, "Samsung")
                .values(2L, "iphone")
                .execute();
    }

    @Test
    void whenDataInsertedThenFindAllReturnThemTest() {
        List<Brand> brands = brandRepository.findAll();
        assertThat(brands)
                .hasSize(2)
                .doesNotHaveDuplicates()
                .extracting(Brand::getName)
                .containsExactly("iphone", "Samsung")
                .doesNotContainNull()
                .doesNotContain("xiaomi");
    }

    @Test
    void whenDataInsertedThenFindOneReturnItTest() {
        assertThat(brandRepository.findOne(1L))
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", "Samsung");
    }

    @Test
    void whenDataNotInsertedThenFindOneReturnNullTest() {
        assertThat(brandRepository.findOne(999L))
                .isNull();
    }

    @Test
    void whenBrandInsertThenReturnItTest() {
        String testName = "some brand";
        Brand brand = brandRepository.create(testName);
        assertThat(brand)
                .hasFieldOrPropertyWithValue("name", testName);
        assertThat(brand.getId())
                .isPositive();
    }

    @Test
    void whenDataNotInsertedThenFindOneReturnEmptyOptionalTest() {
        assertThat(brandRepository.findOneOptional(999L))
                .isEmpty();
    }

    @Test
    void whenDataInsertedThenFindOneOptionalReturnItTest() {
        Optional<Brand> result = brandRepository.findOneOptional(1L);
        assertThat(result)
                .isPresent();
        assertThat(result.get())
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", "Samsung");
    }

    @Test
    void whenDataInsertedCreateDuplicateEntityThenThrowsExceptionTest() {
        String testName = "Samsung";
        assertThatThrownBy(() -> brandRepository.create(testName)).
                isInstanceOf(DuplicateKeyException.class);
    }
}
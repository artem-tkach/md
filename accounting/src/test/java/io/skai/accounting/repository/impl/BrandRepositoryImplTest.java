package io.skai.accounting.repository.impl;

import io.skai.accounting.BaseApplicationContext;
import io.skai.accounting.jooq.Tables;
import io.skai.accounting.jooq.tables.pojos.Brand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BrandRepositoryImplTest extends BaseApplicationContext {
    private final Brand SAMSUNG = new Brand(1L, "Samsung");
    private final Brand IPHONE = new Brand(2L, "iPhone");

    @BeforeEach
    void prepareTable() {
        addTestRecords();
    }

    @AfterEach
    void resetTable() {
        clearTableBrand();
    }


    private void clearTableBrand() {
        dslContext
                .truncate(Tables.BRAND)
                .execute();
    }

    private void addTestRecords() {
        brandRepository.create(SAMSUNG.getName());
        brandRepository.create(IPHONE.getName());
    }

    @Test
    void whenDataInsertedThenFindAllReturnThem() {
        List<Brand> brands = brandRepository.findAll();
        assertThat(brands)
                .containsExactlyInAnyOrder(SAMSUNG, IPHONE);
    }

    @Test
    void whenDataInsertedThenFindOneReturnIt() {
        assertThat(brandRepository.findOne(SAMSUNG.getId()))
                .isEqualTo(SAMSUNG);
        assertThat(brandRepository.findOne(IPHONE.getId()))
                .isEqualTo(IPHONE);
    }

    @Test
    void whenDataNotInsertedThenFindOneReturnNull() {

        long notPresentIdInDB = 999L;
        assertThat(brandRepository.findOne(notPresentIdInDB))
                .isNull();
    }

    @Test
    void whenBrandInsertThenReturnIt() {
        String testName = "some brand";
        Brand brand = brandRepository.create(testName);
        assertThat(brand)
                .hasFieldOrPropertyWithValue("name", testName);
        assertThat(brand.getId())
                .isPositive();
    }

    @Test
    void whenDataInsertedCreateDuplicateEntityThenThrowsException() {
        String testName = SAMSUNG.getName();
        assertThatThrownBy(() -> brandRepository.create(testName)).
                isInstanceOf(DuplicateKeyException.class);
    }
}
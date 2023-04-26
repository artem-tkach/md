package io.skai.accounting.repository.impl;

import io.skai.accounting.BaseApplicationContext;
import io.skai.accounting.dto.model.ModelInfoDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.pojos.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.skai.accounting.jooq.Tables.MODEL;
import static org.assertj.core.api.Assertions.assertThat;

class ModelRepositoryImplTest extends BaseApplicationContext {
    private static final String SAMSUNG = "Samsung";
    public static final String XIAOMI = "Xiaomi";
    private Model galaxy13;
    private final Model GALAXY_14 = new Model(null, 1L, "Galaxy 14");

    @AfterEach
    void clearTableModel() {
        dslContext.truncate(MODEL).execute();
    }

    @BeforeEach
    void addTestRecords() {
        Brand samsung = brandRepository.findOrCreate(SAMSUNG);
        Brand xiaomi = brandRepository.findOrCreate(XIAOMI);
        galaxy13 = modelRepository.findOrCreate(samsung.getId(), "Galaxy 13");//move to constant
        modelRepository.findOrCreate(xiaomi.getId(), "MI9 SE");
    }

    @Test
    void whenDataInsertedCreateNewThenReturnIt() {
        Model model = modelRepository.findOrCreate(GALAXY_14.getBrandId(), GALAXY_14.getName());
        assertThat(model)
                .satisfies(m -> assertThat(m.getId())
                        .isPositive())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(GALAXY_14);
    }

    @Test
    void whenDataInsertedGetAllByBrandThenReturnIt() {
        List<Model> models = modelRepository.findAll(galaxy13.getBrandId());
        assertThat(models)
                .containsExactlyInAnyOrder(galaxy13);
    }

    @Test
    void shouldFindModelInfo() {
        ModelInfoDto expected = new ModelInfoDto(galaxy13.getId(), galaxy13.getName(), 1L, SAMSUNG);
        ModelInfoDto result = modelRepository.findModelInfo(galaxy13.getId());
        assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("brandId")
                .isEqualTo(expected);
    }
}

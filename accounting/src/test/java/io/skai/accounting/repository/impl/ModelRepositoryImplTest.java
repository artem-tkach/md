package io.skai.accounting.repository.impl;

import io.skai.accounting.BaseApplicationContext;
import io.skai.accounting.jooq.tables.pojos.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.skai.accounting.jooq.Tables.MODEL;
import static org.assertj.core.api.Assertions.assertThat;

class ModelRepositoryImplTest extends BaseApplicationContext {
    private final Model GALAXY_13 = new Model(1L, 1L, "Galaxy 13");
    private final Model GALAXY_14 = new Model(null, 1L, "Galaxy 14");
    private final Model MI9_SE = new Model(2L, 2L, "MI9 SE");

    @AfterEach
    void clearTableModel() {
        dslContext
                .truncate(MODEL)
                .execute();
    }

    @BeforeEach
    void addTestRecords() {
        modelRepository.create(GALAXY_13.getBrandId(), GALAXY_13.getName());
        modelRepository.create(MI9_SE.getBrandId(), MI9_SE.getName());
    }

    @Test
    void whenDataInsertedCreateNewThenReturnIt() {
        Model model = modelRepository.create(GALAXY_14.getBrandId(), GALAXY_14.getName());
        assertThat(model)
                .satisfies(m -> assertThat(m.getId())
                        .isPositive())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(GALAXY_14);
    }

    @Test
    void whenDataInsertedGetAllByBrandThenReturnIt() {
        List<Model> models = modelRepository.findAll(GALAXY_13.getBrandId());
        assertThat(models)
                .containsExactlyInAnyOrder(GALAXY_13);
    }
}

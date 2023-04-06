package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Model;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static io.skai.accounting.jooq.Tables.MODEL;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ModelRepositoryImplTest {
    @Autowired
    private ModelRepositoryImpl modelRepository;
    @Autowired
    private DSLContext dslContext;

    @BeforeEach
    void prepareTables() {
        clearTableModel();
        addTestRecords();
    }

    private void clearTableModel() {
        dslContext
                .truncate(MODEL)
                .execute();
    }

    private void addTestRecords() {
        dslContext.insertInto(MODEL, MODEL.BRAND_ID, MODEL.NAME)
                .values(1L, "Galaxy 13")
                .values(2L, "MI9 SE")
                .execute();
    }

    @Test
    void whenDataInsertedCreateNewThenReturnIt() {
        Model model = modelRepository.create(1L, "Galaxy 99");
        assertThat(model)
                .hasFieldOrPropertyWithValue("name", "Galaxy 99");
        assertThat(model.getId())
                .isPositive();
    }

    @Test
    void whenDataInsertedGetAllByBrandThenReturnIt() {
        List<Model> models = modelRepository.findAll(1L);
        assertThat(models)
                .hasSize(1)
                .doesNotHaveDuplicates()
                .extracting(Model::getName)
                .containsExactly("Galaxy 13")
                .doesNotContainNull()
                .doesNotContain("Galaxy 99", "MI9 SE");
    }
}

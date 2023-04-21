package io.skai.warehouse.repository;

import com.kenshoo.pl.entity.PLCondition;
import com.kenshoo.pl.entity.PLContext;
import io.skai.warehouse.command.CreateBrandCommand;
import io.skai.warehouse.command.builder.BrandCommandsBuilder;
import io.skai.warehouse.dto.BrandDto;
import io.skai.warehouse.model.BrandEntity;
import io.skai.warehouse.table.BrandInfoTable;
import io.skai.warehouse.table.BrandTable;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
class BrandPersistenceTest {

    @Container
    private static final MySQLContainer container = new MySQLContainer<>("mysql:latest");

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @AfterEach
    public void clearTables() {
        plContext.dslContext()
                .truncate(BrandInfoTable.TABLE)
                .execute();
        plContext.dslContext()
                .delete(BrandTable.TABLE)
                .execute();
    }

    @Resource
    private BrandPersistence brandPersistence;

    @Resource
    private PLContext plContext;

    @Autowired
    private BrandCommandsBuilder brandCommandsBuilder;

    @Test
    void shouldCreateOneNewBrand() {
        BrandDto dto = new BrandDto(null, "Samsung", "Korea", "https://samsung.com/");
        List<CreateBrandCommand> command = brandCommandsBuilder.buildCreateCommands(List.of(dto));

        final var queryBeforeInsert = plContext
                .select(BrandEntity.ID)
                .from(BrandEntity.INSTANCE)
                .where(BrandEntity.NAME.eq("Samsung"))
                .fetch();

        brandPersistence.create(command);

        final var queryAfterInsert = plContext
                .select(BrandEntity.ID)
                .from(BrandEntity.INSTANCE)
                .where(BrandEntity.NAME.eq("Samsung"))
                .fetch();

        assertThat(queryAfterInsert).hasSize(1);
        assertThat(queryBeforeInsert).isEmpty();
    }

    @Test
    void shouldCreateTwoNewBrands() {
        BrandDto dto1 = new BrandDto(null, "Samsung", "Korea", "https://samsung.com/");
        BrandDto dto2 = new BrandDto(null, "iPhone", "iPhone", "https://iphone.com/");
        List<CreateBrandCommand> command = brandCommandsBuilder.buildCreateCommands(List.of(dto1, dto2));

        brandPersistence.create(command);

        final var queryAfterInsert = plContext
                .select(BrandEntity.ID)
                .from(BrandEntity.INSTANCE)
                .where(PLCondition.trueCondition())
                .fetch();

        assertThat(queryAfterInsert).hasSize(2);
    }
}
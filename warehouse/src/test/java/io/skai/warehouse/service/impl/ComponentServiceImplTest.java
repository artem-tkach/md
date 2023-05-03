package io.skai.warehouse.service.impl;

import com.kenshoo.pl.entity.PLContext;
import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.service.ComponentService;
import io.skai.warehouse.table.ComponentResiduesTable;
import io.skai.warehouse.table.ComponentTable;
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
class ComponentServiceImplTest {

    private static final String SCREEN = "screen";
    private static final String KEYBOARD = "keyboard";
    private static final String TOUCHPAD = "touchpad";

    @Container
    private static final MySQLContainer container = new MySQLContainer<>("mysql:latest");

    @Autowired
    private ComponentService componentService;

    @Resource
    private PLContext plContext;

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @AfterEach
    protected void clearTables(){
        plContext.dslContext()
                .delete(ComponentTable.TABLE)
                .execute();
        plContext.dslContext()
                .delete(ComponentResiduesTable.TABLE)
                .execute();
    }

    @Test
    void shouldWriteToDbThenReturnItCheckIdArePositive() {
        List<ComponentDto> inputData = getInputData();
        List<ComponentDto> result = componentService.create(inputData);
        assertThat(result)
                .isNotEmpty()
                .allMatch(componentDto -> componentDto.id() > 0);
    }

    @Test
    void shouldWriteToDbThenReturnItCheckContainNames() {
        String fieldName = "name";
        List<ComponentDto> inputData = getInputData();
        List<ComponentDto> result = componentService.create(inputData);
        assertThat(result)
                .extracting(fieldName)
                .containsExactlyInAnyOrder(TOUCHPAD, KEYBOARD, SCREEN);
    }

    @Test
    void shouldUpdateDataAndReturnTrue(){
        List<ComponentDto> components = componentService.create(getInputData());
        List<ComponentDto> toUpdate = components.stream()
                .map(component->buildNew(component,1d))
                .toList();
        Boolean result = componentService.updateResidues(toUpdate);
        assertThat(result).isTrue();
    }

    @Test
    void shouldDenyUpdatingAndReturnFalse(){
        List<ComponentDto> components = componentService.create(getInputData());
        List<ComponentDto> moreThanPresent = components.stream()
                .map(component->buildNew(component, 999d))
                .toList();
        Boolean result = componentService.updateResidues(moreThanPresent);
        assertThat(result).isFalse();
    }

    private List<ComponentDto> getInputData() {
        return List.of(new ComponentDto(null, SCREEN,15d,10d),
                new ComponentDto(null, KEYBOARD,20d,10d),
                new ComponentDto(null, TOUCHPAD,25d, 10d));
    }

    private ComponentDto buildNew(ComponentDto component, Double count){
        return new ComponentDto(component.id(),component.name(),count,0d);
    }
}
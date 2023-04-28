package io.skai.warehouse.service.impl;

import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.service.ComponentService;
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

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Test
    void shouldWriteToDbThenReturnIt() {
        List<ComponentDto> inputData = getInputData();
        List<ComponentDto> result = componentService.create(inputData);
        assertThat(result).hasSize(3)
                .allMatch(n -> n.id() > 0)
                .extracting("name")
                .containsExactlyInAnyOrder(TOUCHPAD, KEYBOARD, SCREEN);
    }

    private List<ComponentDto> getInputData() {
        return List.of(new ComponentDto(null, SCREEN,0d,0d),
                new ComponentDto(null, KEYBOARD,0d,0d),
                new ComponentDto(null, TOUCHPAD,0d, 0d));
    }
}
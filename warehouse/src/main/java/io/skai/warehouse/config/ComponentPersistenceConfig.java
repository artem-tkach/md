package io.skai.warehouse.config;

import com.kenshoo.pl.entity.PLContext;
import io.skai.warehouse.repository.ComponentPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ComponentPersistenceConfig {

    private final PLContext plContext;

    @Bean
    public ComponentPersistence componentPersistence() {
        return new ComponentPersistence(plContext);
    }
}
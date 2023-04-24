package io.skai.warehouse.config;

import com.kenshoo.pl.entity.PLContext;
import io.skai.warehouse.repository.BrandPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BrandPersistenceConfig {

    private final PLContext plContext;

    @Bean
    public BrandPersistence brandPersistence(){
        return new BrandPersistence(plContext);
    }
}
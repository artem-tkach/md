package io.skai.warehouse.config;

import io.skai.warehouse.cache.CacheStore;
import io.skai.warehouse.model.component.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheStoreConfig {

    @Bean
    public CacheStore<Component> employeeCache() {
        return new CacheStore<>(120, TimeUnit.MINUTES);
    }
}
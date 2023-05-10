package io.skai.warehouse.config.cache;

import io.skai.warehouse.cache.ComponentCacheStore;
import io.skai.warehouse.repository.ComponentPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CacheStoreConfig {

    private final ComponentPersistence componentPersistence;
    private final CacheProperties cacheProperties;

    @Bean
    public ComponentCacheStore componentCache() {
        return new ComponentCacheStore(cacheProperties.getExpiryDuration(), cacheProperties.getTimeUnit(), componentPersistence);
    }
}
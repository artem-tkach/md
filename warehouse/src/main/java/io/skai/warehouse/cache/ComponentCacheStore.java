package io.skai.warehouse.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import io.skai.warehouse.model.component.Component;
import io.skai.warehouse.repository.ComponentPersistence;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class ComponentCacheStore {

    ComponentPersistence componentPersistence;

    private final LoadingCache<Long, Component> cache;

    public ComponentCacheStore(int expiryDuration, TimeUnit timeUnit, ComponentPersistence componentPersistence) {
        this.componentPersistence = componentPersistence;
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(expiryDuration, timeUnit)
                .build(getCacheLoader());
    }

    public Optional<Component> get(Long key) {
        return Optional.ofNullable(cache.getUnchecked(key));
    }

    private CacheLoader<Long, Component> getCacheLoader() {
        return new CacheLoader<>() {
            @Override
            public Component load(Long key){
                return componentPersistence.find(key);
            }
        };
    }

    public void invalidate(Long key){
        cache.invalidate(key);
    }

    public <T extends Collection<Long>> void invalidate(T keys){
        keys.forEach(this::invalidate);
    }

    public Long size(){
        return cache.size();
    }
}
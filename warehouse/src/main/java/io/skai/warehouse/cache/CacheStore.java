package io.skai.warehouse.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CacheStore<T> {

    private Cache<Long, T> cache;

    public CacheStore(int expiryDuration, TimeUnit timeUnit) {
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(expiryDuration, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
    }

    public Optional<T> get(Long key) {
        return Optional.ofNullable(cache.getIfPresent(key));
    }

    public void add(Long key, T value) {
        if (key != null && value != null) {
            cache.put(key, value);
        }
    }
}
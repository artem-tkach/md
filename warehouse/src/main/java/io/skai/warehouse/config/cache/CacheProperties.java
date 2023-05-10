package io.skai.warehouse.config.cache;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConfigurationProperties(prefix = "guava-cache")
@Getter
@Setter
public class CacheProperties {

    private int expiryDuration;
    private TimeUnit timeUnit;
}
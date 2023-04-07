package io.skai.accounting.feign.clients;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationClientConfig {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}

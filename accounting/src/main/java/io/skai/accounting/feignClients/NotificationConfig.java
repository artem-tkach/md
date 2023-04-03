package io.skai.accounting.feignClients;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}

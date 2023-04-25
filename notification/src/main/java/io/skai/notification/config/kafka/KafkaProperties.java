package io.skai.notification.config.kafka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
@Getter
@Setter
public class KafkaProperties {

    public static final String ORDER_NOTIFICATION_TOPIC_NAME = "orderNotification";
    public static final String CONSUMER_GROUP_ID = "notification";

    private String bootstrapServers;
}
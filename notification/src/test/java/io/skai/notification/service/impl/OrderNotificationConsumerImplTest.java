package io.skai.notification.service.impl;

import io.skai.notification.config.kafka.KafkaProperties;
import io.skai.notification.enums.OrderStatus;
import io.skai.notification.model.Notification;
import io.skai.notification.service.OrderNotificationConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;
import org.testcontainers.utility.DockerImageName;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test")
class OrderNotificationConsumerImplTest {

    @Autowired
    private KafkaProperties kafkaProperties;
    @SpyBean
    private OrderNotificationConsumer orderNotificationConsumer;
    @Captor
    private ArgumentCaptor<Notification> argumentCaptor;

    @Container
    static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

    @DynamicPropertySource
    static void kafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
    }

    @Test
    void shouldReadEntityFromKafka() throws ExecutionException, InterruptedException {
        Notification message = buildNotification();
        try (KafkaProducer<String, Notification> producer = buildProducer()) {
            producer.send(new ProducerRecord<>(kafkaProperties.getTopicName(), "testcontainers", message)).get();
            verify(orderNotificationConsumer, timeout(1000)).consume(argumentCaptor.capture());
            Notification result = argumentCaptor.getValue();
            assertThat(result).isEqualTo(message);
        }
    }

    private KafkaProducer<String, Notification> buildProducer() {
        return new KafkaProducer<>(
                ImmutableMap.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaContainer.getBootstrapServers(),
                        ProducerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString()),
                new StringSerializer(),
                new JsonSerializer<>());
    }

    private Notification buildNotification() {
        return new Notification(null, 1L, OrderStatus.NEW, 2L, "Samsung",
                33L, "M13", "Not turns on", "email@email.com");
    }
}
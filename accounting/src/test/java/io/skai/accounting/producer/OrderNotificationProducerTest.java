package io.skai.accounting.producer;

import io.skai.accounting.config.kafka.KafkaProperties;
import io.skai.accounting.dto.notification.OrderNotificationDto;
import io.skai.accounting.enums.OrderStatus;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test")
class OrderNotificationProducerTest {

    @Autowired
    private OrderNotificationProducer orderNotificationProducer;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Container
    static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

    @DynamicPropertySource
    static void kafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
    }

    @Test
    void shouldWriteToKafkaAndThenReadMessage() {
        KafkaConsumer<String, OrderNotificationDto> consumer = buildKafkaConsumer();
        consumer.subscribe(Collections.singletonList(kafkaProperties.getTopicName()));
        OrderNotificationDto dto = buildNotificationDto();
        orderNotificationProducer.produce(buildNotificationDto());

        ConsumerRecords<String, OrderNotificationDto> records = consumer.poll(Duration.ofMillis(1000));

        assertThat(records)
                .hasSize(1)
                .extracting(ConsumerRecord::topic, ConsumerRecord::value)
                        .containsExactly(tuple(kafkaProperties.getTopicName(), dto));
    }

    private OrderNotificationDto buildNotificationDto() {
        return OrderNotificationDto.builder()
                .orderId(1L)
                .orderStatus(OrderStatus.NEW)
                .brandId(2L)
                .brand("Samsung")
                .modelId(33L)
                .model("M13")
                .defect("Not turns on")
                .email("email@email.com")
                .build();
    }

    private KafkaConsumer<String, OrderNotificationDto> buildKafkaConsumer() {
        return new KafkaConsumer<>(
                ImmutableMap.of(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaContainer.getBootstrapServers(),
                        ConsumerConfig.GROUP_ID_CONFIG, "tc-" + UUID.randomUUID(),
                        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"),
                new StringDeserializer(),
                new JsonDeserializer<>(OrderNotificationDto.class));
    }
}
package io.skai.accounting.producer;

import io.skai.accounting.config.kafka.KafkaProperties;
import io.skai.accounting.dto.notification.OrderNotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderNotificationProducer {

    private final KafkaTemplate<String, OrderNotificationDto> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void produce(OrderNotificationDto dto){
        kafkaTemplate.send(kafkaProperties.getTopicName(), dto);
    }
}
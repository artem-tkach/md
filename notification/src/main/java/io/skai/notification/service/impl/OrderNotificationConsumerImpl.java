package io.skai.notification.service.impl;

import io.skai.notification.model.Notification;
import io.skai.notification.service.NotificationService;
import io.skai.notification.service.OrderNotificationConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static io.skai.notification.config.kafka.KafkaProperties.ORDER_NOTIFICATION_TOPIC_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderNotificationConsumerImpl implements OrderNotificationConsumer {

    private final NotificationService notificationService;

    @Override
    @KafkaListener(topics = ORDER_NOTIFICATION_TOPIC_NAME, groupId = "notification",
            containerFactory = "registerKafkaListenerContainerFactory")
    public void consume(@Payload Notification notification) {
        notificationService.notify(notification);
    }
}
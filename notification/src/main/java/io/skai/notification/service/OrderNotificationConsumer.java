package io.skai.notification.service;

import io.skai.notification.model.Notification;

public interface OrderNotificationConsumer {

    void consume(Notification notification);
}
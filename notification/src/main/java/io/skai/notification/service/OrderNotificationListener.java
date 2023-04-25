package io.skai.notification.service;

import io.skai.notification.model.Notification;

public interface OrderNotificationListener {

    void listen(Notification notification);
}
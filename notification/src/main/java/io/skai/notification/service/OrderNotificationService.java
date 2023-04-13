package io.skai.notification.service;

import io.skai.notification.model.Notification;

public interface OrderNotificationService {
    void notifyAboutNewOrder(final Notification notification);
}

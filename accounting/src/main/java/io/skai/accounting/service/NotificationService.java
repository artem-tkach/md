package io.skai.accounting.service;

import io.skai.accounting.dto.notification.OrderNotificationDto;
import io.skai.accounting.jooq.tables.pojos.Order;

public interface NotificationService {
    void notify(Order order);

    OrderNotificationDto buildNotification(Order order);
}

package io.skai.notification.service;

import io.skai.notification.dto.NewOrderNotificationRequestDto;

public interface OrderNotificationService {
    void notifyAboutNewOrder(final NewOrderNotificationRequestDto dto);
}

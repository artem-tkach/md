package io.skai.notification.service;

import io.skai.notification.dto.NewOrderRequestDto;

public interface OrderNotificationService {
    void notifyAboutNewOrder(final NewOrderRequestDto dto);
}

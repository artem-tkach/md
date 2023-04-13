package io.skai.notification.service.impl;

import io.skai.notification.model.Notification;
import io.skai.notification.service.OrderNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderNotificationServiceImpl implements OrderNotificationService {

    @Override
    public void notifyAboutNewOrder(Notification notification) {
        throw new UnsupportedOperationException("in progress...");
    }
}

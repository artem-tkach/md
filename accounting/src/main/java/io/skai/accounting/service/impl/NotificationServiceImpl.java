package io.skai.accounting.service.impl;

import io.skai.accounting.dto.notificationDto.NewOrderDto;
import io.skai.accounting.feign.clients.NotificationClient;
import io.skai.accounting.jooq.tables.pojos.Order;
import io.skai.accounting.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationClient notificationClient;
    @Override
    @Async
    public void asyncNotifyAboutNewOrder(Order order) {
        NewOrderDto dto = NewOrderDto.builder()
                .orderId(order.getId())
                .model("Some model")
                .defect(order.getDefect())
                .build();
        notificationClient.notifyAboutNewOrder(dto);
    }
}

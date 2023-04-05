package io.skai.accounting.service.impl;

import io.skai.accounting.dto.notificationDto.NewOrderDto;
import io.skai.accounting.feignClients.NotificationClient;
import io.skai.accounting.jooq.tables.pojos.Order;
import io.skai.accounting.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationClient notificationClient;
    @Override
    @Async
    public void notifyAboutNewOrder(final Order order) {
        NewOrderDto dto = NewOrderDto.builder()
                .orderId(order.getId())
                .model("Some model")
                .defect(order.getDefect())
                .build();
        notificationClient.notifyAboutNewOrder(dto);
    }
}

package io.skai.accounting.service.impl;

import io.skai.accounting.dto.model.ModelInfoDto;
import io.skai.accounting.dto.notification.OrderNotificationDto;
import io.skai.accounting.enums.OrderStatus;
import io.skai.accounting.jooq.tables.pojos.Order;
import io.skai.accounting.producer.OrderNotificationProducer;
import io.skai.accounting.service.ClientService;
import io.skai.accounting.service.ModelService;
import io.skai.accounting.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderNotificationService implements NotificationService {

    private final ClientService clientService;
    private final ModelService modelService;
    private final OrderNotificationProducer orderNotificationProducer;

    @Override
    public void notify(Order order) {
        orderNotificationProducer.produce(buildNotification(order));
    }

    @Override
    public OrderNotificationDto buildNotification(Order order) {
        ModelInfoDto modelInfo = modelService.findModelInfo(order.getModelId());

        return OrderNotificationDto.builder()
                .orderId(order.getId())
                .orderStatus(OrderStatus.NEW)
                .brandId(modelInfo.brandId())
                .brand(modelInfo.brand())
                .modelId(order.getModelId())
                .model(modelInfo.name())
                .defect(order.getDefect())
                .email(clientService.find(order.getClientId()).getEmail())
                .build();
    }
}
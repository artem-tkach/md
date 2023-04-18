package io.skai.accounting.service.impl;

import io.skai.accounting.dto.order.OrderDto;
import io.skai.accounting.dto.order.OrderRequestDto;
import io.skai.accounting.jooq.tables.pojos.Order;
import io.skai.accounting.mappers.OrderMapper;
import io.skai.accounting.repository.OrderRepository;
import io.skai.accounting.service.NotificationService;
import io.skai.accounting.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@EnableAsync

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final NotificationService notificationService;

    @Override
    public OrderDto createAndNotify(OrderRequestDto dto) {
        Order order = orderRepository.findOrCreate(orderMapper.toOrder(dto));
        notificationService.asyncNotifyAboutNewOrder(order);
        return orderMapper.toResponseDto(order);
    }
}
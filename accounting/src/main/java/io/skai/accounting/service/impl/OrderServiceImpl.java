package io.skai.accounting.service.impl;

import io.skai.accounting.dto.order.OrderRequestDto;
import io.skai.accounting.dto.order.OrderResponseDto;
import io.skai.accounting.jooq.tables.pojos.Order;
import io.skai.accounting.mappers.OrderMapper;
import io.skai.accounting.repository.OrderRepository;
import io.skai.accounting.service.NotificationService;
import io.skai.accounting.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@EnableAsync
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final NotificationService notificationService;

    @Override
    public OrderResponseDto createAndNotify(final OrderRequestDto dto) {
        //Todo: add order validation
        Order order = orderRepository.create(orderMapper.toOrder(dto));
        notificationService.notifyAboutNewOrder(order);
        return orderMapper.toResponseDto(order);
    }
}

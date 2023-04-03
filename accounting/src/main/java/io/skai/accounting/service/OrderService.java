package io.skai.accounting.service;

import io.skai.accounting.dto.order.OrderRequestDto;
import io.skai.accounting.dto.order.OrderResponseDto;


public interface OrderService {
    OrderResponseDto createAndNotify(OrderRequestDto dto);
}

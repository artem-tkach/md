package io.skai.accounting.service;

import io.skai.accounting.dto.order.OrderRequestDto;
import io.skai.accounting.dto.order.OrderDto;


public interface OrderService {
    OrderDto createAndNotify(OrderRequestDto dto);
}

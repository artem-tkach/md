package io.skai.accounting.mappers;

import io.skai.accounting.dto.order.OrderRequestDto;
import io.skai.accounting.dto.order.OrderDto;
import io.skai.accounting.jooq.tables.pojos.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    Order toOrder(OrderRequestDto dto);

    OrderDto toResponseDto(Order order);
}

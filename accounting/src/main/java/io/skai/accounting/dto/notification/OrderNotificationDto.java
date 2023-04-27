package io.skai.accounting.dto.notification;

import io.skai.accounting.enums.OrderStatus;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class OrderNotificationDto {

    Long orderId;
    OrderStatus orderStatus;
    Long brandId;
    String brand;
    Long modelId;
    String model;
    String defect;
    String email;
}
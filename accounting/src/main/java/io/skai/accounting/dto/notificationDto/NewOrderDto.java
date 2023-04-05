package io.skai.accounting.dto.notificationDto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class NewOrderDto {
    Long orderId;
    String model;
    String defect;
}

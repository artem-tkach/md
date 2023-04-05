package io.skai.notification.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class NewOrderRequestDto {
    String model;
    Long orderId;
    String defect;
}

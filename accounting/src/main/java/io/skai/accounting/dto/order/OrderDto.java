package io.skai.accounting.dto.order;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class OrderDto {
    Long id;
    Long clientId;
    Long modelId;
    String serialNumber;
    String defect;
    Long managerId;
}

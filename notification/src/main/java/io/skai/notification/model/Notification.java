package io.skai.notification.model;

import io.skai.notification.enums.OrderStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static io.skai.notification.util.ValidationMessages.*;

public record Notification(Long id,
                           @NotNull(message = NULL_ORDER_ID)
                           @Min(value = 1L, message = NEGATIVE_ORDER_ID)
                           Long orderId,
                           @NotNull(message = NULL_ORDER_STATUS)
                           OrderStatus orderStatus,
                           @NotNull(message = NULL_BRAND_ID)
                           @Min(value = 1L, message = NEGATIVE_BRAND_ID)
                           Long brandId,
                           @NotBlank(message = BLANK_BRAND_NAME)
                           String brand,
                           @NotNull(message = NULL_MODEL_ID)
                           @Min(value = 1L, message = NEGATIVE_MODEL_ID)
                           Long modelId,
                           @NotBlank(message = BLANK_MODEL_NAME)
                           String model,
                           @NotBlank(message = BLANK_DEFECT)
                           String defect,
                           @Email
                           String email) {
}
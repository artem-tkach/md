package io.skai.notification.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationMessages {
    public static final String NULL_ORDER_ID = "Order id must be not null";
    public static final String NEGATIVE_ORDER_ID = "Order id must be greater than 0";
    public static final String BLANK_MODEL_NAME = "Model name must have at least one character";
    public static final String BLANK_BRAND_NAME = "Model name must have at least one character";
    public static final String NULL_BRAND_ID = "Brand id must be not null";
    public static final String NEGATIVE_BRAND_ID = "Brand id must be greater than 0";
    public static final String NULL_MODEL_ID = "Model id must be not null";
    public static final String NEGATIVE_MODEL_ID = "Model id must be greater than 0";
    public static final String BLANK_DEFECT = "Defect must have at least one character";
}

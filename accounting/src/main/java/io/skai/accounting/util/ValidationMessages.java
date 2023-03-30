package io.skai.accounting.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationMessages {
    public static final String NULL_BRAND_NAME = "Brand name can't be null";
    public static final String SHORT_NAME = "Name must at least 1 character";
    public static final String NULL_BRAND_ID = "Brand id can't be null";
    public static final String NULL_MODEL_NAME = "Model name can't be null";
}

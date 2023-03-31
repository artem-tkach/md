package io.skai.accounting.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationMessages {
    public static final String NULL_BRAND_NAME = "Brand name can't be null";
    public static final String SHORT_NAME = "Name must at least 1 character";
    public static final String NULL_BRAND_ID = "Brand id can't be null";
    public static final String NULL_MODEL_NAME = "Model name can't be null";
    public static final String NULL_CLIENT_NAME = "Client name can't be null";
    public static final String WRONG_EMAIL = "Email doesn't matches pattern. Check it";
    public static final String BLANK_EMAIL = "Email must be provided";
}

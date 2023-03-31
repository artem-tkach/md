package io.skai.accounting.exception;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponseBody {
    Integer status;
    String message;
    Long timeStamp;
    String exception;
    String description;
}

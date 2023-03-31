package io.skai.accounting.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Log4j2
public class ExceptionsHandler {
    //TODO: do messages in readable look
    //https://blog.payara.fish/returning-beautiful-validation-error-messages-in-jakarta-rest-with-exception-mappers
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        log.error("Exception type::{}, message::{}, description::{}",
                exception.getClass().getSimpleName(),exception.getMessage(),request.getDescription(false));
        ErrorResponseBody errorResponse = buildErrorResponseBody(exception, request,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception, WebRequest request) {
        log.error("Exception type::{}, message::{}, description::{}",
                exception.getClass().getSimpleName(),exception.getMessage(),request.getDescription(false));
        ErrorResponseBody errorResponse = buildErrorResponseBody(exception, request,HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponseBody buildErrorResponseBody(final Exception exception,final WebRequest request,final HttpStatus httpStatus){
        return ErrorResponseBody.builder()
                .message(exception.getLocalizedMessage())
                .timeStamp(System.currentTimeMillis())
                .exception(exception.getClass().getName())
                .description(request.getDescription(false))
                .status(httpStatus.value())
                .build();
    }
}

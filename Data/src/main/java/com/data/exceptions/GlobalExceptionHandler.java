package com.data.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final String TRACE = "trace";

    @Value("${reflectoring.trace:false}")
    private boolean printStackTrace;

    private ResponseEntity<ErrorResponse> makeErrorResponseEntity(final ErrorResults errorResult, final String customMessage){
        return ResponseEntity.status(errorResult.getStatus()).body(new ErrorResponse(errorResult.name() ,customMessage));
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<ErrorResponse> handleCustomException(final CustomException exception){
        //log.warn("PetException: ", exception);
        return this.makeErrorResponseEntity(exception.getErrorResult() ,exception.getCustomMessage());
    }
}

package com.data.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorResults {
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND),
    INVALID_VALUE(HttpStatus.UNPROCESSABLE_ENTITY),
    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

    private final HttpStatus status;
}

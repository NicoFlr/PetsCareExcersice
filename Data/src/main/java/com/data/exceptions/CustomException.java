package com.data.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorResults errorResult;
    private final String customMessage;
}

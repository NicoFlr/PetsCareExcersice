package com.data.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



@Getter
@RequiredArgsConstructor
public enum ErrorResults {
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND),
    INVALID_VALUE(HttpStatus.UNPROCESSABLE_ENTITY),
    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

    /*@Autowired
    HttpStatus httpStatus;*/

    private final HttpStatus status;
/*
    ErrorResults(HttpStatus httpStatus) {
        status = httpStatus;
    }

    /*@Autowired
    HttpStatus httpStatus;*/
/*
    public HttpStatus getStatus() {
        return status;
    }
    /*public void setStatus(HttpStatus status){
        this.status = status;
    }*/
}

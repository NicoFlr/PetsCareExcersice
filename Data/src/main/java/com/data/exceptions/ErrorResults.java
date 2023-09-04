package com.data.exceptions;

//import org.springframework.http.HttpStatus;
import lombok.Getter;
//import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



@Getter
@RequiredArgsConstructor
public enum ErrorResults {
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND),;

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

package com.dw.jdbcapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus 의 역할은 사용자정의 예외의 기본 HTTP상태코드를
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(){
        super();
    }
    public InvalidRequestException(String message) {
        super(message);
    }
}


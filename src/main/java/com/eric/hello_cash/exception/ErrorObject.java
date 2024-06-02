package com.eric.hello_cash.exception;

import lombok.Data;

import java.util.Date;
@Data
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}

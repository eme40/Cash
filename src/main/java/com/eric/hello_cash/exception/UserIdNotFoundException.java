package com.eric.hello_cash.exception;

public class UserIdNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public UserIdNotFoundException(String message) {
        super(message);
    }
}

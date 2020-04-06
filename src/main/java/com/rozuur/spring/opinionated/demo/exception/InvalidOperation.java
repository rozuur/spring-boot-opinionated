package com.rozuur.spring.opinionated.demo.exception;

public class InvalidOperation extends RuntimeException {
    public InvalidOperation() {
        super();
    }

    public InvalidOperation(String message) {
        super(message);
    }

    public InvalidOperation(Throwable cause) {
        super(cause);
    }

    public InvalidOperation(String message, Throwable cause) {
        super(message, cause);
    }
}

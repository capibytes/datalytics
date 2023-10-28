package com.api.datalytics.services.exceptions;

import org.springframework.validation.Errors;

import java.io.Serial;

public class MethodArgumentNotValidException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public MethodArgumentNotValidException(String message) {
        super(message);
    }

    public MethodArgumentNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public Errors getBindingResult() {
        return null;
    }
}
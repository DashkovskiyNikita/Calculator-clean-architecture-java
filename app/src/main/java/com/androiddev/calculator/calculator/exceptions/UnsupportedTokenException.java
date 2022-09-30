package com.androiddev.calculator.calculator.exceptions;

public class UnsupportedTokenException extends Exception {

    private static final String MESSAGE = "Unsupported token : ";

    public UnsupportedTokenException(String token) {
        super(MESSAGE + token);
    }
}

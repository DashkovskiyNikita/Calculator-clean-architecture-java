package com.androiddev.calculator.calculator.exceptions;

public class UnsupportedCharacterException extends Exception {

    private static final String MESSAGE = "Unsupported character : ";

    public UnsupportedCharacterException(char ch) {
        super(MESSAGE + ch);
    }
}

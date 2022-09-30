package com.androiddev.calculator.calculator.tokenizer;

import com.androiddev.calculator.calculator.exceptions.UnsupportedCharacterException;

public interface AbstractTokenizer {
    String[] tokenize(String input) throws UnsupportedCharacterException;
}


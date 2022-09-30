package com.androiddev.calculator.calculator.tokenizer;

import com.androiddev.calculator.calculator.checker.AbstractChecker;
import com.androiddev.calculator.calculator.exceptions.UnsupportedCharacterException;
import org.jetbrains.annotations.NotNull;

public class CalculatorTokenizer implements AbstractTokenizer {

    private static final String SPACER = " ";
    private static final String NO_SPACE = "";
    private final AbstractChecker checker;

    public CalculatorTokenizer(AbstractChecker checker) {
        this.checker = checker;
    }

    @Override
    public String[] tokenize(@NotNull String input) throws UnsupportedCharacterException {
        char[] factors = input.replaceAll(SPACER, NO_SPACE).toCharArray();
        StringBuilder builder = new StringBuilder();

        boolean lastWasDigit = false;

        for (char ch : factors) {
            String factor = String.valueOf(ch);
            if (checker.isDigit(factor)) {
                if (!lastWasDigit) builder.append(SPACER);
                lastWasDigit = true;
                builder.append(ch);
            } else if (checker.isLeftBracket(factor) ||
                    checker.isRightBracket(factor)) {
                lastWasDigit = false;
                if (builder.length() > 0) builder.append(SPACER);
                builder.append(ch);
            } else if (checker.isOperator(factor)) {
                lastWasDigit = false;
                builder.append(SPACER).append(ch);
            } else {
                throw new UnsupportedCharacterException(ch);
            }
        }
        String result = builder.toString().trim();
        return result.split(SPACER);
    }
}

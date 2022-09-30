package com.androiddev.calculator.calculator;

import androidx.annotation.Nullable;

import com.androiddev.calculator.calculator.exceptions.UnsupportedCharacterException;
import com.androiddev.calculator.calculator.exceptions.UnsupportedTokenException;
import com.androiddev.calculator.calculator.solver.AbstractExpressionSolver;
import com.androiddev.calculator.calculator.tokenizer.AbstractTokenizer;

import java.math.MathContext;

public final class Calculator {

    private final AbstractTokenizer tokenizer;
    private final AbstractExpressionSolver solver;

    public Calculator(AbstractTokenizer tokenizer, AbstractExpressionSolver solver) {
        this.tokenizer = tokenizer;
        this.solver = solver;
    }

    public void setMathContext(MathContext context) {
        solver.setContext(context);
    }

    public @Nullable String calculate(String expression) {
        try {
            String[] tokens = tokenizer.tokenize(expression);
            return solver.solve(tokens);
        } catch (UnsupportedCharacterException | UnsupportedTokenException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.androiddev.calculator.calculator.solver;

import com.androiddev.calculator.calculator.checker.AbstractChecker;
import com.androiddev.calculator.calculator.exceptions.UnsupportedTokenException;
import com.androiddev.calculator.calculator.provider.AbstractStrategyProvider;

import java.math.MathContext;

public abstract class AbstractExpressionSolver {

    protected final AbstractChecker checker;
    protected final AbstractStrategyProvider provider;
    protected MathContext context;

    public AbstractExpressionSolver(
            AbstractChecker checker,
            AbstractStrategyProvider provider,
            MathContext context
    ) {
        this.checker = checker;
        this.provider = provider;
        this.context = context;
    }

    public void setContext(MathContext context) {
        this.context = context;
    }

    public abstract String solve(String[] tokens) throws UnsupportedTokenException;
}

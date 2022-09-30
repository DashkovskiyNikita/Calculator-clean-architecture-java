package com.androiddev.calculator.calculator.functions;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class FunctionStrategy {
    private final String name;
    private final int priority;
    private final int numArgs;

    public FunctionStrategy(String name, int priority, int numArgs) {
        this.name = name;
        this.priority = priority;
        this.numArgs = numArgs;
    }

    abstract BigDecimal execute(MathContext context, String... args);

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getNumArgs() {
        return numArgs;
    }
}

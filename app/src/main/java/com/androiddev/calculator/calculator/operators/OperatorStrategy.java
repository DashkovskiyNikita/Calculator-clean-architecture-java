package com.androiddev.calculator.calculator.operators;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class OperatorStrategy implements Comparable<OperatorStrategy> {

    private final String name;
    private final int priority;
    private final boolean isRightAssociativity;

    public OperatorStrategy(String name, int priority, boolean isRightAssociativity) {
        this.name = name;
        this.priority = priority;
        this.isRightAssociativity = isRightAssociativity;
    }

    public abstract BigDecimal execute(String arg1, String arg2, MathContext context);

    @Override
    public int compareTo(@NotNull OperatorStrategy another) {
        return Integer.compare(priority, another.getPriority());
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean isRightAssociativity() {
        return isRightAssociativity;
    }
}

package com.androiddev.calculator.calculator.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public class PowStrategy extends OperatorStrategy {

    public PowStrategy() {
        super("^", 3, true);
    }

    @Override
    public BigDecimal execute(String arg1, String arg2, MathContext context) {
        BigDecimal first = new BigDecimal(arg1);
        int n = Integer.parseInt(arg2);
        return first.pow(n, context);
    }
}

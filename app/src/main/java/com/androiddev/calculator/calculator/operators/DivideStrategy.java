package com.androiddev.calculator.calculator.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public class DivideStrategy extends OperatorStrategy {

    public DivideStrategy() {
        super("/", 2, false);
    }

    @Override
    public BigDecimal execute(String arg1, String arg2, MathContext context) {
        BigDecimal first = new BigDecimal(arg1);
        BigDecimal second = new BigDecimal(arg2);
        return first.divide(second, context);
    }
}

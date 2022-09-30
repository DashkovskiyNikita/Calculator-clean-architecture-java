package com.androiddev.calculator.calculator.provider;

import com.androiddev.calculator.calculator.functions.FunctionStrategy;
import com.androiddev.calculator.calculator.operators.OperatorStrategy;


public interface AbstractStrategyProvider {
    OperatorStrategy getOperator(String name);

    FunctionStrategy getFunction(String name);

    boolean isOperatorPresent(String name);

    boolean isFunctionPresent(String name);
}

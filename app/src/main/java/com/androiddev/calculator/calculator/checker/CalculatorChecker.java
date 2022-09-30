package com.androiddev.calculator.calculator.checker;

import com.androiddev.calculator.calculator.operators.OperatorStrategy;
import com.androiddev.calculator.calculator.provider.AbstractStrategyProvider;

import org.jetbrains.annotations.NotNull;


public class CalculatorChecker implements AbstractChecker {

    private static final String L_BRACKET = "(";
    private static final String R_BRACKET = ")";

    private final AbstractStrategyProvider provider;

    public CalculatorChecker(AbstractStrategyProvider strategyProvider) {
        this.provider = strategyProvider;
    }

    @Override
    public boolean isOperator(String input) {
        return provider.isOperatorPresent(input);
    }

    @Override
    public boolean isFunction(String input) {
        return false;
    }

    @Override
    public boolean isLeftBracket(String input) {
        return L_BRACKET.equals(input);
    }

    @Override
    public boolean isRightBracket(String input) {
        return R_BRACKET.equals(input);
    }

    @Override
    public boolean isDigit(@NotNull String input) {
        return Character.isDigit(input.charAt(0));
    }

    @Override
    public boolean isRightAssociativity(String op1, String op2) {
        OperatorStrategy s1 = provider.getOperator(op1);
        OperatorStrategy s2 = provider.getOperator(op2);
        return s1.isRightAssociativity() && s2.isRightAssociativity();
    }

    @Override
    public int compareOperators(String op1, String op2) {
        OperatorStrategy s1 = provider.getOperator(op1);
        OperatorStrategy s2 = provider.getOperator(op2);
        return s1.compareTo(s2);
    }

}

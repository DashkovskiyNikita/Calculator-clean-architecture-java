package com.androiddev.calculator.calculator.checker;

public interface AbstractChecker {

    boolean isOperator(String input);

    boolean isFunction(String input);

    boolean isLeftBracket(String input);

    boolean isRightBracket(String input);

    boolean isDigit(String input);

    boolean isRightAssociativity(String op1,String op2);

    int compareOperators(String op1,String op2);

}

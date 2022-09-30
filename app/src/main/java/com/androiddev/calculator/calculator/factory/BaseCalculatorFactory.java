package com.androiddev.calculator.calculator.factory;

import com.androiddev.calculator.calculator.Calculator;
import com.androiddev.calculator.calculator.checker.AbstractChecker;
import com.androiddev.calculator.calculator.checker.CalculatorChecker;
import com.androiddev.calculator.calculator.provider.AbstractStrategyProvider;
import com.androiddev.calculator.calculator.provider.CalculatorStrategyProvider;
import com.androiddev.calculator.calculator.solver.AbstractExpressionSolver;
import com.androiddev.calculator.calculator.solver.ExpressionSolver;
import com.androiddev.calculator.calculator.tokenizer.AbstractTokenizer;
import com.androiddev.calculator.calculator.tokenizer.CalculatorTokenizer;

import java.math.MathContext;
import java.math.RoundingMode;

public class BaseCalculatorFactory implements CalculatorFactory{
    @Override
    public Calculator create() {
        AbstractStrategyProvider provider = new CalculatorStrategyProvider();
        AbstractChecker checker = new CalculatorChecker(provider);
        MathContext context = new MathContext(15, RoundingMode.HALF_DOWN);
        AbstractExpressionSolver solver = new ExpressionSolver(checker, provider, context);
        AbstractTokenizer tokenizer = new CalculatorTokenizer(checker);
        return new Calculator(tokenizer, solver);
    }
}

package com.androiddev.calculator.calculator.provider;

import com.androiddev.calculator.calculator.functions.FunctionStrategy;
import com.androiddev.calculator.calculator.operators.DivideStrategy;
import com.androiddev.calculator.calculator.operators.MultiplyStrategy;
import com.androiddev.calculator.calculator.operators.OperatorStrategy;
import com.androiddev.calculator.calculator.operators.PlusStrategy;
import com.androiddev.calculator.calculator.operators.PowStrategy;
import com.androiddev.calculator.calculator.operators.SubtractStrategy;

import java.util.HashMap;

public class CalculatorStrategyProvider implements AbstractStrategyProvider {

    private final HashMap<String, OperatorStrategy> operators;
    private final HashMap<String, FunctionStrategy> functions;

    public CalculatorStrategyProvider() {
        this.operators = new HashMap<>();
        this.functions = new HashMap<>();
        //plus
        OperatorStrategy plus = new PlusStrategy();
        operators.put(plus.getName(), plus);
        //subtract
        OperatorStrategy subtract = new SubtractStrategy();
        operators.put(subtract.getName(), subtract);
        //divide
        OperatorStrategy divide = new DivideStrategy();
        operators.put(divide.getName(), divide);
        //multiply
        OperatorStrategy multiply = new MultiplyStrategy();
        operators.put(multiply.getName(), multiply);
        //pow
        OperatorStrategy pow = new PowStrategy();
        operators.put(pow.getName(), pow);
    }

    @Override
    public OperatorStrategy getOperator(String name) {
        return operators.get(name);
    }

    @Override
    public FunctionStrategy getFunction(String name) {
        return functions.get(name);
    }

    @Override
    public boolean isOperatorPresent(String name) {
        return operators.containsKey(name);
    }

    @Override
    public boolean isFunctionPresent(String name) {
        return functions.containsKey(name);
    }
}

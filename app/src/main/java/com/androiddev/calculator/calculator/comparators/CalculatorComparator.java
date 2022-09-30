package com.androiddev.calculator.calculator.comparators;

import com.androiddev.calculator.calculator.functions.FunctionStrategy;
import com.androiddev.calculator.calculator.operators.OperatorStrategy;
import com.androiddev.calculator.calculator.provider.AbstractStrategyProvider;

public interface CalculatorComparator extends OperatorsComparator, FunctionsComparator {

    class Base implements CalculatorComparator {

        private final AbstractStrategyProvider provider;

        public Base(AbstractStrategyProvider provider) {
            this.provider = provider;
        }

        @Override
        public int compareFunctions(String f1, String f2) {
            FunctionStrategy first = provider.getFunction(f1);
            FunctionStrategy second = provider.getFunction(f2);
            return Integer.compare(first.getPriority(), second.getPriority());
        }

        @Override
        public int compareOperators(String op1, String op2) {
            OperatorStrategy first = provider.getOperator(op1);
            OperatorStrategy second = provider.getOperator(op2);
            return Integer.compare(first.getPriority(), second.getPriority());
        }
    }

}


package com.androiddev.calculator.domain.models;

import java.io.Serializable;

public class CalculatorHistoryModel implements Serializable {
    private static final long serialVersionUID = 8625632490103450104L;
    private String expression;
    private String result;

    public CalculatorHistoryModel(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }
}

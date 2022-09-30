package com.androiddev.calculator.calculator.solver;

import com.androiddev.calculator.calculator.checker.AbstractChecker;
import com.androiddev.calculator.calculator.exceptions.UnsupportedTokenException;
import com.androiddev.calculator.calculator.operators.OperatorStrategy;
import com.androiddev.calculator.calculator.provider.AbstractStrategyProvider;
import org.jetbrains.annotations.NotNull;

import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionSolver extends AbstractExpressionSolver {

    public ExpressionSolver(
            AbstractChecker checker,
            AbstractStrategyProvider provider,
            MathContext context
    ) {
        super(checker, provider, context);
    }

    @Override
    public String solve(String @NotNull [] tokens) throws UnsupportedTokenException {
        Deque<String> operands = new ArrayDeque<>();
        Deque<String> operations = new ArrayDeque<>();
        for (String token : tokens) {
            if (checker.isDigit(token)) {
                operands.push(token);
            } else if (checker.isLeftBracket(token)) {
                operations.push(token);
            } else if (checker.isRightBracket(token)) {
                processBracketStatement(operands, operations);
            } else if (checker.isOperator(token)) {
                processOperator(operands, operations, token);
            } else {
                throw new UnsupportedTokenException(token);
            }
        }
        while (!operations.isEmpty()) {
            applyOperator(operands, operations.pop());
        }
        return operands.pop();
    }

    private void processOperator(
            @NotNull Deque<String> args,
            @NotNull Deque<String> ops,
            String token
    ) {
        String prevOp = ops.peek();
        if (ops.isEmpty() ||
                checker.isLeftBracket(prevOp) ||
                checker.compareOperators(prevOp, token) < 0 ||
                checker.isRightAssociativity(prevOp, token)
        ) {
            ops.push(token);
            return;
        }
        applyOperator(args, ops.pop());
        ops.push(token);
    }

    private void processBracketStatement(
            @NotNull Deque<String> operands,
            @NotNull Deque<String> operations
    ) {
        do {
            applyOperator(operands, operations.pop());
        } while (!checker.isLeftBracket(operations.peek()));
        operations.pop();
    }

    private void applyOperator(@NotNull Deque<String> operands, String op) {
        OperatorStrategy s = provider.getOperator(op);
        String arg2 = operands.pop();
        String arg1 = operands.pop();
        String result = s.execute(arg1, arg2, context).toPlainString();
        operands.push(result);
    }
}

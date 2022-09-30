package com.androiddev.calculator.calculator.functions;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;

public class SqrtFunction extends FunctionStrategy {

    public SqrtFunction() {
        super("sqrt", 100, 1);
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    BigDecimal execute(MathContext context, String @NotNull ... args) {
        BigDecimal value = new BigDecimal(args[0]);
        return value.sqrt(context);
    }
}

package com.androiddev.calculator.calculator.result;

@FunctionalInterface
public interface Error<T> {
    void apply(T error);
}

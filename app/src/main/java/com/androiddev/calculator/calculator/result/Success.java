package com.androiddev.calculator.calculator.result;

@FunctionalInterface
public interface Success<T> {
    void apply(T data);
}

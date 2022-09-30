package com.androiddev.calculator.presentation.viewmodels;

import androidx.lifecycle.ViewModel;

abstract class CalculatorScreenViewModel extends ViewModel {
    abstract void buttonPressed(String value);

    abstract void calculate();

    abstract void clear();
}


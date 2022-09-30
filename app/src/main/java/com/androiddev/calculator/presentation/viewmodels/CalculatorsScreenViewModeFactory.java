package com.androiddev.calculator.presentation.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androiddev.calculator.calculator.Calculator;
import com.androiddev.calculator.domain.models.CalculatorHistoryModel;
import com.androiddev.calculator.domain.storage.CalculatorHistoryStorage;

public class CalculatorsScreenViewModeFactory
        implements ViewModelProvider.Factory {

    private final Calculator calculator;
    private final CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage;

    public CalculatorsScreenViewModeFactory(
            @NonNull Calculator calculator,
            CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage
    ) {
        this.calculator = calculator;
        this.historyStorage = historyStorage;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CalculatorScreenViewModelImpl(calculator, historyStorage);
    }
}

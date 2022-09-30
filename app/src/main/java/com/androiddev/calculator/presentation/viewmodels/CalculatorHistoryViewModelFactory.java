package com.androiddev.calculator.presentation.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androiddev.calculator.domain.models.CalculatorHistoryModel;
import com.androiddev.calculator.domain.storage.CalculatorHistoryStorage;

public class CalculatorHistoryViewModelFactory
        implements ViewModelProvider.Factory {

    private final CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage;

    public CalculatorHistoryViewModelFactory(
            CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage) {
        this.historyStorage = historyStorage;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CalculatorHistoryViewModelImpl(historyStorage);
    }
}

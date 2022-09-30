package com.androiddev.calculator.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.androiddev.calculator.calculator.Calculator;
import com.androiddev.calculator.domain.models.CalculatorHistoryModel;
import com.androiddev.calculator.domain.storage.CalculatorHistoryStorage;

import java.util.concurrent.CompletableFuture;

public class CalculatorScreenViewModelImpl extends CalculatorScreenViewModel {

    private final Calculator calculator;
    private final CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage;
    private StringBuilder stringBuilder;

    private final MutableLiveData<String> _expression = new MutableLiveData<>();
    LiveData<String> expression = _expression;

    private final MutableLiveData<String> _result = new MutableLiveData<>();
    LiveData<String> result = _result;

    public CalculatorScreenViewModelImpl(
            Calculator calculator,
            CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage
    ) {
        this.calculator = calculator;
        this.historyStorage = historyStorage;
        this.stringBuilder = new StringBuilder();
    }

    @Override
    void buttonPressed(String value) {
        stringBuilder.append(value);
        _expression.setValue(stringBuilder.toString());
    }

    @Override
    void calculate() {
        CompletableFuture
                .supplyAsync(_expression::getValue)
                .thenApplyAsync(calculator::calculate)
                .thenAcceptAsync(this::postResultAndSave);
    }

    private void postResultAndSave(String result) {
        _result.postValue(result);
        String exp = _expression.getValue();
        CalculatorHistoryModel historyModel
                = new CalculatorHistoryModel(exp, result);
        historyStorage.insert(historyModel);
    }

    @Override
    void clear() {
        stringBuilder = new StringBuilder();
        _expression.setValue("");
        _result.setValue("");
    }
}

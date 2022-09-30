package com.androiddev.calculator.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.androiddev.calculator.domain.models.CalculatorHistoryModel;
import com.androiddev.calculator.domain.storage.CalculatorHistoryStorage;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class CalculatorHistoryViewModelImpl extends CalculatorHistoryViewModel {

    private final CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage;

    private final MutableLiveData<ArrayList<CalculatorHistoryModel>> _history = new MutableLiveData<>();
    LiveData<ArrayList<CalculatorHistoryModel>> history = _history;

    public CalculatorHistoryViewModelImpl(
            CalculatorHistoryStorage<CalculatorHistoryModel> historyStorage) {
        this.historyStorage = historyStorage;
        getHistory();
    }

    private void getHistory() {
        CompletableFuture
                .supplyAsync(historyStorage::getAll)
                .thenAcceptAsync(_history::postValue);
    }
}

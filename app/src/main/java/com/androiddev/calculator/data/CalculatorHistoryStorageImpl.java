package com.androiddev.calculator.data;


import com.androiddev.calculator.domain.models.CalculatorHistoryModel;
import com.androiddev.calculator.domain.storage.CalculatorHistoryStorage;

import java.util.ArrayList;

public class CalculatorHistoryStorageImpl
        implements CalculatorHistoryStorage<CalculatorHistoryModel> {

    private SerializableHelper serializableHelper;
    private ArrayList<CalculatorHistoryModel> history;
    private final int historySize;
    private static final String fileName = "calculator_history.ser";

    public CalculatorHistoryStorageImpl(int historySize) {
        this.historySize = historySize;
        this.history = null;
    }

    @Override
    public ArrayList<CalculatorHistoryModel> getAll() {
        if (history == null) loadHistory();
        return history;
    }

    @Override
    public void insert(CalculatorHistoryModel data) {
        if (history == null) loadHistory();
        history.add(data);
        if(history.size() == historySize){
            history.remove(0);
        }
        serializableHelper.serialize(fileName, history);
    }

    @SuppressWarnings("unchecked")
    private void loadHistory() {
        Object result = serializableHelper.deserialize(fileName);
        if (result != null) {
            history = (ArrayList<CalculatorHistoryModel>) result;
        } else {
            history = new ArrayList<>();
        }
    }
}

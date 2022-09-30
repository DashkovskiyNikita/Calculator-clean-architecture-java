package com.androiddev.calculator.presentation.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androiddev.calculator.R;
import com.androiddev.calculator.databinding.CalculatorHistoryScreenBinding;

public class CalculatorHistoryFragment extends Fragment {

    private CalculatorHistoryScreenBinding binding;

    public CalculatorHistoryFragment() {
        super(R.layout.calculator_history_screen);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = CalculatorHistoryScreenBinding.bind(view);
    }
}

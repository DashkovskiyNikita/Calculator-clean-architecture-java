package com.androiddev.calculator.presentation.ui;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androiddev.calculator.R;
import com.androiddev.calculator.databinding.CalculatorScreenBinding;

public class CalculatorFragment extends Fragment {

    private CalculatorScreenBinding binding;

    public CalculatorFragment() {
        super(R.layout.calculator_screen);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = CalculatorScreenBinding.bind(view);
    }
}

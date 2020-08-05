package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.jetpackdemo.databinding.ActivityCalculatorBinding;
import com.example.jetpackdemo.viewmodel.CalculatorViewModel;

public class CalculatorActivity extends AppCompatActivity {
    CalculatorViewModel calculatorViewModel;
    ActivityCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_calculator);
        calculatorViewModel= new ViewModelProvider(this).get(CalculatorViewModel.class);
        binding.setCalculator(calculatorViewModel);
        binding.setLifecycleOwner(this);

    }
}
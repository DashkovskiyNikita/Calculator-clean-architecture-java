package com.androiddev.calculator.domain.storage;

import com.androiddev.calculator.domain.crud.GetAll;
import com.androiddev.calculator.domain.crud.Insert;

import java.io.Serializable;

public interface CalculatorHistoryStorage<T> extends Insert<T>, GetAll<T> { }

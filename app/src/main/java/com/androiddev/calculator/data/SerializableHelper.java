package com.androiddev.calculator.data;

public interface SerializableHelper {

    Object deserialize(String fileName);

    void serialize(String fileName, Object data);
}

package com.androiddev.calculator.data;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AndroidSerializableHelper implements SerializableHelper {

    private final Context context;

    public AndroidSerializableHelper(Context context) {
        this.context = context;
    }

    @Override
    public Object deserialize(String fileName) {
        try (FileInputStream fileStream = context.openFileInput(fileName);
             ObjectInputStream objInputStream = new ObjectInputStream(fileStream)
        ) {
            return objInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void serialize(String fileName, Object data) {
        try (FileOutputStream fileStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
             ObjectOutputStream objOutputStream = new ObjectOutputStream(fileStream)
        ) {
            objOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

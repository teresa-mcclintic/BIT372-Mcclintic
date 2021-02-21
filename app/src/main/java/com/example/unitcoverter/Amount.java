package com.example.unitcoverter;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Amount {
    private MutableLiveData<String> currentValue2Convert;
    private MutableLiveData<String> converted;

    public LiveData<String> getCurrentValue2Convert(){
        if (currentValue2Convert == null){
            currentValue2Convert = new MutableLiveData<>();
            currentValue2Convert.setValue("1");
        }
        return currentValue2Convert;
    }
    public LiveData<String> getConverted(){
        if (converted == null){
            converted = new MutableLiveData<>();
            converted.setValue("1");
        }
        return converted;
    }
    public void changeConverted(String value) {
        this.converted.setValue(value);
    }




}

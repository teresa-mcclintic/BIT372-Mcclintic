package com.example.unitcoverter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import android.os.Build;
import android.os.Bundle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModel extends ViewModel {

    public MutableLiveData<String> value2convert = new MutableLiveData<>();
    public MutableLiveData<String> converted = new MutableLiveData<>();





    public LiveData<String> getValue2Convert() {
        if (value2convert == null){
            value2convert = new MutableLiveData<>();
            value2convert.setValue("1");
        }
        return value2convert;
    }
    public LiveData<String> getConvertedObservable() {
        if (converted == null){
            converted = new MutableLiveData<>();
            converted.setValue("1");
        }
        return converted;
    }
    public String getValue2ConvertString(){
        return value2convert.getValue();
    }
    public Integer getValue2ConvertInteger(){
        return Integer.valueOf(String.valueOf(getValue2Convert()));
    }

    public String getConverted() {

        return this.converted.getValue();
    }

    public void setConverted(String value) {

        converted.setValue(value);
    }


}

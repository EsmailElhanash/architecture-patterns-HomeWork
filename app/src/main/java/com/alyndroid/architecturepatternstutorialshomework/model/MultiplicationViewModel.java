package com.alyndroid.architecturepatternstutorialshomework.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class MultiplicationViewModel extends ViewModel {

    public MutableLiveData<Integer> result = new MutableLiveData<>();

    public void calculate(){
        NumberModel numberModel = new DataBase().getNumbers();
        result.setValue(numberModel.getFirstNum() * numberModel.getSecondNum());
    }
}

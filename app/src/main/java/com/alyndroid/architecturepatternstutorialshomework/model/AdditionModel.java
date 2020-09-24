package com.alyndroid.architecturepatternstutorialshomework.model;

public class AdditionModel {
    private int n1 , n2;

    public AdditionModel(NumberModel numberModel) {
        this.n1 = numberModel.getFirstNum();
        this.n2 = numberModel.getSecondNum();
    }

    public int add(){
        return n1 + n2;
    }
}

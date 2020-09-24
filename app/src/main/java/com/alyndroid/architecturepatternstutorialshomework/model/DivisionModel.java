package com.alyndroid.architecturepatternstutorialshomework.model;

public class DivisionModel {
    int n1;
    int n2;

    public DivisionModel(NumberModel numberModel) {
        this.n1 = numberModel.getFirstNum();
        this.n2 = numberModel.getSecondNum();
    }

    public int divide(){
        return n1/n2;
    }
}

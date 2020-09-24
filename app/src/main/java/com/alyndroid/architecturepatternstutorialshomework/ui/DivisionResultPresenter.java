package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.DivisionModel;

public class DivisionResultPresenter {
    OnDivisionCalculated listener;

    public DivisionResultPresenter(OnDivisionCalculated listener) {
        this.listener = listener;
    }

    public void calculate(){
        int result = new DivisionModel(new DataBase().getNumbers()).divide();
        listener.onDivisionResultReady(result);
    }

}

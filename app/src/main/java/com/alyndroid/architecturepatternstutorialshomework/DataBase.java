package com.alyndroid.architecturepatternstutorialshomework;

import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class DataBase {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}

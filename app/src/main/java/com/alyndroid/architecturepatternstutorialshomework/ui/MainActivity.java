package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.model.AdditionModel;
import com.alyndroid.architecturepatternstutorialshomework.model.MultiplicationViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , OnDivisionCalculated{
    ActivityMainBinding binding;
    MultiplicationViewModel multiplicationViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);

        multiplicationViewModel = ViewModelProviders.of(this).get(MultiplicationViewModel.class);
        multiplicationViewModel.result.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.mulResultTextView.setText(String.valueOf(integer));
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.plus_button:
                int result = new AdditionModel(new DataBase().getNumbers()).add();
                binding.plusResultTextView.setText(String.valueOf(result));
                break;
            case R.id.div_button:
                new DivisionResultPresenter(this).calculate();
                break;
            case R.id.mul_button:
                multiplicationViewModel.calculate();
                break;

        }
    }

    @Override
    public void onDivisionResultReady(int result) {
        binding.divResultTextView.setText(String.valueOf(result));
    }
}

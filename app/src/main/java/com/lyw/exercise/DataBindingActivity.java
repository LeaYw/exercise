package com.lyw.exercise;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lyw.exercise.databinding.ActivityDataBindingBinding;
import com.lyw.exercise.model.User;

public class DataBindingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding);
        User user = new User("test test",11);
        binding.setUser(user);
        binding.setHandler(this);
    }

    public void onClickName(View view) {
        Toast.makeText(this,"hahaha",Toast.LENGTH_SHORT).show();
    }
}

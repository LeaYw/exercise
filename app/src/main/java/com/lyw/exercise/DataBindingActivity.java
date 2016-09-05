package com.lyw.exercise;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lyw.exercise.databinding.Custom;
import com.lyw.exercise.model.User;

public class DataBindingActivity extends AppCompatActivity {
    private Custom binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        user = new User("sdlkfjlds", 12);
        binding.setUser(user);
        binding.setHandler(this);
    }

    public void onClickName(View view) {
        user.setName("test test");
        startActivity(new Intent(this,DataBinding2Activity.class));
    }

}

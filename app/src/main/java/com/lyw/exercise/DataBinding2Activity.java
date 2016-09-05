package com.lyw.exercise;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lyw.exercise.databinding.Custom2;
import com.lyw.exercise.model.People;

public class DataBinding2Activity extends AppCompatActivity {
    private Custom2 binding;
    private People people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding2);
        people = new People();
        binding.setPeople(people);
        people.name.set("custom2");
        people.age.set(18);
        people.isMan.set(true);
    }
}

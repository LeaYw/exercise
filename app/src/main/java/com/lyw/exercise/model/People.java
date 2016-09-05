package com.lyw.exercise.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class People {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean isMan = new ObservableBoolean();


}

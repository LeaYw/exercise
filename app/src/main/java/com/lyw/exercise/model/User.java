package com.lyw.exercise.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.lyw.exercise.BR;

public class User extends BaseObservable{
    private String name;
    private int age;

    public User(){

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Bindable
    public int getAge() {
        return age;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}

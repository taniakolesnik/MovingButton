package com.example.movingbutton;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private int counter;

    public MyViewModel() {
        this.counter = 0;
    }

    public int getCount() {
        return counter;
    }

    public void setCount(int counter) {
        this.counter = counter;
    }
}

package com.kapusta.jprotestapp.service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class CounterImpl extends Counter {

    private int counter;


    public CounterImpl() {
        super();
        counter = 0;
    }


    @Override
    public void increment() {
        counter++;
        super.increment();
    }

    @Override
    public String getCurrentValue() {
        return String.valueOf(counter);
    }





}

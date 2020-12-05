package com.kapusta.jprotestapp.service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Counter {
    private List<Supplier> consumers;

    public Counter() {
        this.consumers = new LinkedList<>();
    }

    public void increment() {
        acceptConsumer();
    }

    public abstract String getCurrentValue();

    public void onIncrement(Supplier supplier) {
        consumers.add(supplier);
    }

    private void acceptConsumer() {
        consumers.forEach(Supplier::get);
    }
}

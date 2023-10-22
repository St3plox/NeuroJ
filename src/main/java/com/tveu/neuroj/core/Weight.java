package com.tveu.neuroj.core;

import java.util.Random;


public class Weight {
    private final double value;

    private final double weightChange;

    public Weight(double value) {
        weightChange = 0;
        this.value = value;
    }

    public Weight() {
        this(new Random().nextDouble() * 0.5); //Random [-0.5, 0.5]
    }

    public double getValue() {
        return value;
    }

    public double getWeightChange() {
        return weightChange;
    }

}


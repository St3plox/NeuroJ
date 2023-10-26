package com.tveu.neuroj.core;

import java.util.Objects;
import java.util.Random;


public class Weight {
    private double value;

    private double weightChange;

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

    public void setValue(double value) {
        weightChange += this.value - value;
        
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight weight)) return false;
        return Double.compare(value, weight.value) == 0 && Double.compare(weightChange, weight.weightChange) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, weightChange);
    }
}
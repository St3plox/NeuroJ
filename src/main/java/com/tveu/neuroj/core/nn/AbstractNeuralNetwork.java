package com.tveu.neuroj.core.nn;

import java.io.Serializable;

public abstract class AbstractNeuralNetwork implements Serializable {

    protected double output;

    public abstract void setInputVector(double[] inputVector);

    public abstract void calculateOutput();

    public double getOutput() {
        return output;
    }

}
package com.tveu.neuroj.core.function;

public abstract class AbstractActivationFunction {

    protected double output;
    protected boolean isOutputSet = false;

    public abstract double getOutput(double totalInput);

    public abstract double getDerivative(double totalInput);

    public void reset() {
        isOutputSet = false;
    }

}
package com.tveu.neuroj.core.function;

public abstract class AbstractActivationFunction {

    protected double output;

    public abstract double getOutput(double totalInput);

    public abstract double  getDerivative(double totalInput);
}
package com.tveu.neuroj.core.function;

public class LinearFunction extends AbstractActivationFunction {
    @Override
    public double getOutput(double totalInput) {
        return totalInput;
    }

    @Override
    public double getDerivative(double totalInput) {
        return 1;
    }
}

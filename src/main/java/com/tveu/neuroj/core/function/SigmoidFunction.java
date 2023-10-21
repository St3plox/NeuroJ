package com.tveu.neuroj.core.function;

public class SigmoidFunction extends AbstractActivationFunction {

    @Override
    public double getOutput(double totalInput) {

        output = 1 / (1 + Math.exp(-1 * totalInput));
        return output;
    }

    @Override
    public double getDerivative(double totalInput) {

        getOutput(totalInput);
        return output * (1 - output);
    }
}

package com.tveu.neuroj.core.function;

public class ReLuFunctionAbstract extends AbstractActivationFunction {


    @Override
    public double getOutput(double totalInput) {

        output = Math.max(0, totalInput);
        return output;
    }

    @Override
    public double getDerivative(double totalInput) {
        return totalInput > 0 ? 1 : 0;
    }
}

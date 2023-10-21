package com.tveu.neuroj.core.function.parametric;

public class PReLuFunction extends AbstractParametricFunction{

    protected PReLuFunction(double slope) {
        super(slope);
    }

    @Override
    public double getOutput(double totalInput) {

        output = Math.max(slope, totalInput);
        return output;
    }

    @Override
    public double getDerivative(double totalInput) {
        return totalInput > 0 ? 1.0 : slope;
    }
}

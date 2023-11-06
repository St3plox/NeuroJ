package com.tveu.neuroj.core.function.parametric;

public class ELUFunction extends AbstractParametricFunction {

    public ELUFunction(double slope) {
        super(slope);
    }

    @Override
    public double getOutput(double totalInput) {

        output = (totalInput >= 0) ? totalInput : slope * (Math.exp(totalInput) - 1);
        isOutputSet = true;
        return output;
    }

    @Override
    public double getDerivative(double totalInput) {

        if (!isOutputSet) {
            getOutput(totalInput);
        }

        return (totalInput >= 0) ? 1 : output + slope;
    }
}

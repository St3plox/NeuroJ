package com.tveu.neuroj.core.function;

public class TanhFunction extends AbstractActivationFunction {
    @Override
    public double getOutput(double totalInput) {

        output = (Math.exp(totalInput) - Math.exp(-1 * totalInput))
                /
                (Math.exp(totalInput) + Math.exp(-1 * totalInput));

        isOutputSet = true;

        return output;
    }

    @Override
    public double getDerivative(double totalInput) {

        if (!isOutputSet) {
            getOutput(totalInput);
        }

        return 1.0 - output * output;
    }
}

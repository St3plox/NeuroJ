package com.tveu.neuroj.core.function.parametric;

import com.tveu.neuroj.core.function.AbstractActivationFunction;

public abstract class AbstractParametricFunction extends AbstractActivationFunction {

    protected final double slope;

    protected AbstractParametricFunction(double slope) {
        this.slope = slope;
    }
}

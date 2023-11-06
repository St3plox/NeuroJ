package com.tveu.neuroj.core.neuron;

import com.tveu.neuroj.core.Layer;
import com.tveu.neuroj.core.function.AbstractActivationFunction;

import java.io.Serializable;

public abstract class AbstractNeuron implements Serializable {

    protected final Layer parentLayer;

    protected final AbstractActivationFunction abstractActivationFunction;

    protected double delta;

    protected double totalInput;

    public AbstractNeuron(Layer parentLayer, AbstractActivationFunction abstractActivationFunction) {
        delta = 0;

        this.parentLayer = parentLayer;
        this.abstractActivationFunction = abstractActivationFunction;
    }

    public Layer getParentLayer() {
        return parentLayer;
    }

    public AbstractActivationFunction getAbstractActivationFunction() {
        return abstractActivationFunction;
    }

    public void setTotalInput(double totalInput) {
        this.totalInput = totalInput;
    }

    public double getTotalInput() {
        return totalInput;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public void generateOutput(){

    }


}
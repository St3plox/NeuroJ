package com.tveu.neuroj.core;

import com.tveu.neuroj.core.function.AbstractActivationFunction;

import java.util.ArrayList;
import java.util.List;

public class Neuron {

    private double delta;

    private double output;

    private double totalInput;

    List<Connection> inputConnections;

    List<Connection> outputConnections;

    private Layer parentLayer;

    private AbstractActivationFunction abstractActivationFunction;

    public double getDelta() {
        return delta;
    }

    public double getOutput() {
        return output;
    }

    public double getTotalInput() {
        return totalInput;
    }

    public List<Connection> getInputConnections() {
        return new ArrayList<>(inputConnections);
    }

    public List<Connection> getOutputConnections() {
        return new ArrayList<>(outputConnections);
    }

    public Layer getParentLayer() {
        return parentLayer;
    }

    public AbstractActivationFunction getAbstractActivationFunction() {
        return abstractActivationFunction;
    }
}

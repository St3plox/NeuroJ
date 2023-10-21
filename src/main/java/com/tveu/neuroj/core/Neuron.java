package com.tveu.neuroj.core;

import com.tveu.neuroj.core.function.AbstractActivationFunction;

import java.util.List;

public class Neuron {

    private double delta;

    private double output;

    List<Connection> inputConnections;

    List<Connection> outputConnections;

    private Layer parentLayer;

    private AbstractActivationFunction abstractActivationFunction;

}

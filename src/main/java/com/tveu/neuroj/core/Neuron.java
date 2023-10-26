package com.tveu.neuroj.core;

import com.tveu.neuroj.core.function.AbstractActivationFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Neuron {

    private double delta;

    private double output;

    private double totalInput;

    List<Connection> inputConnections;

    List<Connection> outputConnections;

    private final Layer parentLayer;

    private AbstractActivationFunction abstractActivationFunction;


    public Neuron(Layer parentLayer) {
        inputConnections = new ArrayList<>();
        outputConnections = new ArrayList<>();
        delta = 0;
        totalInput = 0;
        output = 0;
        this.parentLayer = parentLayer;
    }
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


    public void setDelta(double delta) {
        this.delta = delta;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public void setTotalInput(double totalInput) {
        this.totalInput = totalInput;
    }

    public void setInputConnections(List<Connection> inputConnections) {
        this.inputConnections = inputConnections;
    }

    public void setOutputConnections(List<Connection> outputConnections) {
        this.outputConnections = outputConnections;
    }

    public void setAbstractActivationFunction(AbstractActivationFunction abstractActivationFunction) {
        this.abstractActivationFunction = abstractActivationFunction;
    }

    public void addOutputConnection(Connection connection) {

        if(connection.getFromNeuron() != this)
            throw new IllegalArgumentException("In output connection fromNeuron must be this");

        outputConnections.add(connection);

        Neuron toNeuron = connection.getToNeuron();
        toNeuron.addInputConnection(connection);
    }

    public void addInputConnection(Connection connection) {

        if (connection.getToNeuron() != this)
            throw new IllegalArgumentException("In input connection toNeuron must be this");


        inputConnections.add(connection);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neuron neuron = (Neuron) o;
        return Double.compare(delta, neuron.delta) == 0 && Double.compare(output, neuron.output) == 0 && Double.compare(totalInput, neuron.totalInput) == 0 && Objects.equals(inputConnections, neuron.inputConnections) && Objects.equals(outputConnections, neuron.outputConnections) && Objects.equals(parentLayer, neuron.parentLayer) && Objects.equals(abstractActivationFunction, neuron.abstractActivationFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delta, output, totalInput, inputConnections, outputConnections, parentLayer, abstractActivationFunction);
    }
}
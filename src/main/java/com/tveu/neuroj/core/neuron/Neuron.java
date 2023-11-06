package com.tveu.neuroj.core.neuron;

import com.tveu.neuroj.core.Connection;
import com.tveu.neuroj.core.Layer;
import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.core.function.SigmoidFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Neuron extends AbstractNeuron {

    protected double delta;

    protected double output;

    protected List<Connection> inputConnections;

    protected List<Connection> outputConnections;

    public Neuron(Layer parentLayer, AbstractActivationFunction abstractActivationFunction) {
        super(parentLayer, abstractActivationFunction);

        inputConnections = new ArrayList<>();
        outputConnections = new ArrayList<>();
    }


    public Neuron(Layer parentLayer) {
        this(parentLayer, new SigmoidFunction());
    }

    public double getOutput() {
        return output;
    }


    public List<Connection> getInputConnections() {
        return inputConnections;
    }

    public List<Connection> getOutputConnections() {
        return outputConnections;
    }

    public void setInputConnections(List<Connection> inputConnections) {
        this.inputConnections = inputConnections;
    }

    public void setOutputConnections(List<Connection> outputConnections) {
        this.outputConnections = outputConnections;
    }


    public void generateOutput() {

        generateTotalInput();

        output = abstractActivationFunction.getOutput(totalInput);
    }

    public void generateTotalInput() {
        totalInput = 0;

        inputConnections.forEach(inputConnection ->
                totalInput += inputConnection.getWeightedInput()
        );
    }

    public void addOutputConnection(Connection connection) {

        if (connection.getFromNeuron() != this)
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
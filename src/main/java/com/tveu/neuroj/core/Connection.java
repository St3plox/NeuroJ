package com.tveu.neuroj.core;

public class Connection {

    private final Neuron fromNeuron;

    private final Neuron toNeuron;

    private Weight weight;

    public Connection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;

        weight = new Weight();
    }

    public Connection(Neuron fromNeuron, Neuron toNeuron, Weight weight) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = weight;
    }

    public final Neuron getFromNeuron() {
        return fromNeuron;
    }

    public final Neuron getToNeuron() {
        return toNeuron;
    }

    public final Weight getWeight() {
        return weight;
    }

    public final void setWeight(Weight weight) {
        this.weight = weight;
    }

    public double getWeightedInput() {
        return fromNeuron.getOutput() * weight.getValue();
    }
}

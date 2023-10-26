package com.tveu.neuroj.core;

import com.tveu.neuroj.core.neuron.Neuron;

import java.util.Objects;

public class Connection {

    private final Neuron fromNeuron;

    private final Neuron toNeuron;

    private Weight weight = new Weight();

    public Connection(Neuron fromNeuron, Neuron toNeuron) {

        if (fromNeuron.getParentLayer() == toNeuron.getParentLayer()) {
            throw new IllegalArgumentException("Neurons from the same layer cannot be connected");
        }

        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
    }

    public Connection(Neuron fromNeuron, Neuron toNeuron, Weight weight) {
        this(fromNeuron, toNeuron);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(fromNeuron, that.fromNeuron) && Objects.equals(toNeuron, that.toNeuron) && Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromNeuron, toNeuron, weight);
    }
}

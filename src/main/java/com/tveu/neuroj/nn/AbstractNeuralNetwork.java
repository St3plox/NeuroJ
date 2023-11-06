package com.tveu.neuroj.nn;

import com.tveu.neuroj.core.Layer;
import com.tveu.neuroj.core.neuron.Neuron;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNeuralNetwork implements Serializable {

    protected List<Layer> layers;

    protected double output;

    public AbstractNeuralNetwork() {
        layers = new ArrayList<>();
    }

    public abstract void calculateOutput();

    public double getOutput() {
        return output;
    }

    public abstract void setInputVector(double[] inputVector);

    public void addLayer(Layer layer) {

        if (!layers.isEmpty()) {
            layers.get(layers.size() - 1).connectAllNeuronsTo(layer);
        }
        layers.add(layer);
    }

    public Layer getLayer(int index) {
        if(index >= layers.size())
            throw new IllegalArgumentException("Layer index is out of bounds");

        return layers.get(index);
    }
}
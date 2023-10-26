package com.tveu.neuroj.core;

import com.tveu.neuroj.core.neuron.Neuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NeuralNetwork {

    private String label;

    protected double output;

    protected List<Layer> layers;

    public NeuralNetwork() {
        layers = new ArrayList<>();
    }

    public NeuralNetwork(List<Layer> layers) {
        this.layers = layers;
    }

    public double getOutput() {
        return output;
    }

    public List<Layer> getLayers() {
        return new ArrayList<>(layers);
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addLayer(Layer layer) {

        if (!layers.isEmpty()) {
            layers.get(layers.size() - 1).connectAllNeuronsTo(layer);
        }
        layers.add(layer);
    }

    public void setInputVector(double[] inputVector) {
        if (layers.isEmpty() ||
                inputVector.length != layers.get(0).neurons.size()) {

            throw new IllegalArgumentException("Neural network has no input layer" +
                    " or input vector do not match with input Neurons amount");
        }

        int i = 0;
        for (Neuron neuron : layers.get(0)) {
            neuron.setTotalInput(inputVector[i]);
            i++;
        }
    }

    public Optional<Layer> getFirstLayerByLabel(String label) {

        for (Layer layer : layers) {
            if (Objects.equals(layer.label, label))
                return Optional.of(layer);
        }

        return Optional.empty();
    }

    public List<Layer> getAllLayersByLabel(String label) {

        List<Layer> result = new ArrayList<>();

        layers.forEach((layer -> {
            if (layer.label.equals(label))
                result.add(layer);
        }));

        return result;
    }

    public void calculateOutput() {

        for (Layer layer : layers) {
            for (Neuron neuron : layer) {
                neuron.generateOutput();
            }
        }

        layers.get(layers.size() - 1).forEach(
                neuron -> output += neuron.getOutput()
        );
    }

}

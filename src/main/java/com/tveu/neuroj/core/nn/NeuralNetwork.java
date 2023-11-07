package com.tveu.neuroj.core.nn;

import com.tveu.neuroj.core.Layer;
import com.tveu.neuroj.core.neuron.Neuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NeuralNetwork extends AbstractNeuralNetwork {

    private String label;

    protected List<Layer> layers;


    public NeuralNetwork() {
        layers = new ArrayList<>();
    }


    public NeuralNetwork(List<Layer> layers) {
        this.layers = layers;
    }

    public List<Layer> getLayers() {
        return layers;
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

    public Layer getLayer(int index) {
        if(index >= layers.size())
            throw new IllegalArgumentException("Layer index is out of bounds");

        return layers.get(index);
    }

    public Optional<Layer> getFirstLayerByLabel(String label) {

        for (Layer layer : layers) {
            if (Objects.equals(layer.getLabel(), label))
                return Optional.of(layer);
        }

        return Optional.empty();
    }

    public List<Layer> getAllLayersByLabel(String label) {

        List<Layer> result = new ArrayList<>();

        layers.forEach((layer -> {
            if (layer.getLabel().equals(label))
                result.add(layer);
        }));

        return result;
    }

    @Override
    public void calculateOutput() {

        output = 0;
        for (Layer layer : layers) {
            for (Neuron neuron : layer) {
                neuron.generateOutput();
                neuron.setDelta(0);
            }
        }

        layers.get(layers.size() - 1).forEach(
                neuron -> output += neuron.getOutput()
        );

    }

    @Override
    public void setInputVector(double[] inputVector) {

    }

}

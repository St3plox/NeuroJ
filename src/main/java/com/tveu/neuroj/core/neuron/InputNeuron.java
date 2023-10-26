package com.tveu.neuroj.core.neuron;

import com.tveu.neuroj.core.Layer;

public class InputNeuron extends Neuron {


    public InputNeuron(Layer parentLayer) {
        super(parentLayer);
    }

    @Override
    public double generateOutput() {
        return totalInput;
    }
}

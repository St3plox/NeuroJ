package com.tveu.neuroj.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LayerTest {

    @Test
    void connectAllNeuronsTo_validConnections_success() {
        Layer layer1 = new Layer(3);
        Layer layer2 = new Layer(2);

        Weight weight = new Weight();

        layer1.connectAllNeuronsTo(layer2, weight);

        assertEquals(2, layer1.getNeurons().get(0).getOutputConnections().size());
        assertEquals(3, layer2.getNeurons().get(0).getInputConnections().size());
    }

    @Test
    void connectAllNeuronsTo_invalidConnections_throwsException() {
        Layer layer1 = new Layer(3);
        Layer layer2 = new Layer(2);

        Weight weight = new Weight();

        // Add an extra neuron to layer2 to make the connection invalid
        layer2.addNeuron(new Neuron(layer2));

        assertThrows(IllegalArgumentException.class, () -> layer1.connectAllNeuronsTo(layer2, weight));
    }

}
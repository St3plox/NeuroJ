package com.tveu.neuroj.core;

import com.tveu.neuroj.core.neuron.Neuron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeuronTest {


    @Test
    void addOutputConnection_invalidConnection_throwsException() {
        Layer layer = new Layer();
        Neuron neuron1 = new Neuron(layer);
        Neuron neuron2 = new Neuron(layer);
        Neuron neuron3 = new Neuron(layer);

        assertThrows(IllegalArgumentException.class, () -> neuron3.addOutputConnection(new Connection(neuron1, neuron2)));
    }

    @Test
    void addOutputConnection_validConnection_success() {
        Layer layer1 = new Layer();
        Layer layer2 = new Layer();

        Neuron neuron1 = new Neuron(layer1);
        Neuron neuron2 = new Neuron(layer2);

        Connection connection = new Connection(neuron1, neuron2);
        neuron1.addOutputConnection(connection);

        assertEquals(neuron2, neuron1.getOutputConnections().get(0).getToNeuron());
    }

}
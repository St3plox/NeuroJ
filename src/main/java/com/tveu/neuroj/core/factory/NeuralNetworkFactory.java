package com.tveu.neuroj.core.factory;

import com.tveu.neuroj.core.Layer;
import com.tveu.neuroj.core.nn.NeuralNetwork;
import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.core.function.LinearFunction;
import com.tveu.neuroj.core.function.SigmoidFunction;

public class NeuralNetworkFactory implements NeuralNetworkFactoryI{

    public final static String INPUT_LAYER_LABEL = "INPUT";
    public final static String HIDDEN_LAYER_LABEL = "HIDDEN";
    public final static String OUTPUT_LAYER_LABEL = "OUTPUT";

    private final NeuralNetwork neuralNetwork;

    public NeuralNetworkFactory() {
        this.neuralNetwork = new NeuralNetwork();
    }

    public NeuralNetworkFactory addInputLayer(int numberOfNeurons) {
        return addLayer(INPUT_LAYER_LABEL, numberOfNeurons, new LinearFunction());
    }

    public NeuralNetworkFactory addHiddenLayer(int numberOfNeurons, AbstractActivationFunction activationFunction) {
        return addLayer(HIDDEN_LAYER_LABEL, numberOfNeurons, activationFunction);
    }

    public NeuralNetworkFactory addOutputLayer(int numberOfNeurons, AbstractActivationFunction activationFunction) {
        return addLayer(OUTPUT_LAYER_LABEL, numberOfNeurons, activationFunction);
    }

    private NeuralNetworkFactory addLayer(String label, int numberOfNeurons, AbstractActivationFunction activationFunction) {
        Layer layer = new Layer(numberOfNeurons);
        layer.setLabel(label);
        neuralNetwork.addLayer(layer);
        return this;
    }

    public NeuralNetwork build() {
        return neuralNetwork;
    }


}

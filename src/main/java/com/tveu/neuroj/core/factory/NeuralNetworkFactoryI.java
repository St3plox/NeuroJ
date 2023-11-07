package com.tveu.neuroj.core.factory;

import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.core.function.SigmoidFunction;
import com.tveu.neuroj.core.nn.NeuralNetwork;

public interface NeuralNetworkFactoryI {

    NeuralNetworkFactory addInputLayer(int numberOfNeurons);

    NeuralNetworkFactory addHiddenLayer(int numberOfNeurons, AbstractActivationFunction activationFunction);

    NeuralNetworkFactory addOutputLayer(int numberOfNeurons, AbstractActivationFunction activationFunction);

    NeuralNetwork build();

    public static NeuralNetworkFactory createDefaultNeuralNetwork() {
        return new NeuralNetworkFactory()
                .addInputLayer(3)
                .addHiddenLayer(5, new SigmoidFunction())
                .addHiddenLayer(5, new SigmoidFunction())
                .addOutputLayer(1, new SigmoidFunction());
    }
}

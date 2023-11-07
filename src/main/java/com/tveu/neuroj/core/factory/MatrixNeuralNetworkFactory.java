package com.tveu.neuroj.core.factory;

import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.core.nn.NeuralNetwork;

public class MatrixNeuralNetworkFactory implements NeuralNetworkFactoryI {
    @Override
    public NeuralNetworkFactory addInputLayer(int numberOfNeurons) {
        return null;
    }

    @Override
    public NeuralNetworkFactory addHiddenLayer(int numberOfNeurons, AbstractActivationFunction activationFunction) {
        return null;
    }

    @Override
    public NeuralNetworkFactory addOutputLayer(int numberOfNeurons, AbstractActivationFunction activationFunction) {
        return null;
    }

    @Override
    public NeuralNetwork build() {
        return null;
    }
}

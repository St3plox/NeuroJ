package com.tveu.neuroj.core.factory;

import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.core.nn.MatrixNeuralNetwork;
import com.tveu.neuroj.core.nn.NeuralNetwork;

public class MatrixNeuralNetworkFactory implements NeuralNetworkFactoryI {

    private final MatrixNeuralNetwork matrixNeuralNetwork;

    public MatrixNeuralNetworkFactory(int inputSize) {
        matrixNeuralNetwork = new MatrixNeuralNetwork(inputSize);
    }


    @Override
    public MatrixNeuralNetworkFactory addHiddenLayer(int numberOfNeurons, AbstractActivationFunction activationFunction) {
        matrixNeuralNetwork.addConnectionWeights(numberOfNeurons);
        matrixNeuralNetwork.setActivationFunction(activationFunction);
        return this;
    }

    @Override
    public MatrixNeuralNetworkFactory addOutputLayer(int numberOfNeurons, AbstractActivationFunction activationFunction) {
        addHiddenLayer(numberOfNeurons, activationFunction);
        return this;
    }

    @Override
    public MatrixNeuralNetwork build() {
        return matrixNeuralNetwork;
    }
}

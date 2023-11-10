package com.tveu.neuroj.core.factory;

import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.core.function.SigmoidFunction;
import com.tveu.neuroj.core.nn.AbstractNeuralNetwork;

public interface NeuralNetworkFactoryI {

    NeuralNetworkFactoryI addHiddenLayer(int numberOfNeurons, AbstractActivationFunction activationFunction);

    NeuralNetworkFactoryI addOutputLayer(int numberOfNeurons, AbstractActivationFunction activationFunction);

    AbstractNeuralNetwork build();
}

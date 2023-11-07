package com.tveu.neuroj.core.train.learning;

import com.tveu.neuroj.core.Connection;
import com.tveu.neuroj.core.Layer;
import com.tveu.neuroj.core.nn.NeuralNetwork;
import com.tveu.neuroj.core.Weight;
import com.tveu.neuroj.core.neuron.Neuron;

public class BackPropagation extends LearningAlgorithm {

    public BackPropagation(double learningRate) {
        super(learningRate);
    }

    protected BackPropagation(double delta, double learningRate) {
        super(delta, learningRate);
    }

    @Override
    public void optimizeWeights(NeuralNetwork neuralNetwork) {

        int layersCount = neuralNetwork.getLayers().size();

        for (int i = layersCount - 1; i > 0; i--) {

            Layer layer = neuralNetwork.getLayers().get(i);
            for (Neuron neuron : layer) {

                double localGradient;

                if (i == layersCount - 1) {
                    localGradient = error * neuron
                            .getAbstractActivationFunction()
                            .getDerivative(neuron.getTotalInput());
                } else {
                    localGradient = neuron.getDelta() * neuron
                            .getAbstractActivationFunction()
                            .getDerivative(neuron.getTotalInput());
                }

                for (Connection connection : neuron.getInputConnections()) {
                    Weight weight = connection.getWeight();

                    // Save the old weight value
                    double oldWeightValue = weight.getValue();

                    Neuron fromNeuron = connection.getFromNeuron();

                    // Update the weight value
                    weight.setValue(oldWeightValue - learningRate * localGradient * fromNeuron.getOutput());


                    // Update the delta for the neuron from the previous layer
                    fromNeuron
                            .setDelta(
                                    fromNeuron.getDelta() + localGradient * weight.getValue()
                                            * fromNeuron.getAbstractActivationFunction()
                                            .getDerivative(fromNeuron.getTotalInput()));
                }
            }

        }
    }
}

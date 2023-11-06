package com.tveu.neuroj.core.train.learning;

import com.tveu.neuroj.nn.NeuralNetwork;

public abstract class LearningAlgorithm {

    protected double error;

    protected final double learningRate;

    public LearningAlgorithm(double learningRate) {
        this.learningRate = learningRate;
    }

    protected LearningAlgorithm(double error, double learningRate) {
        this(learningRate);
        this.error = error;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public abstract void optimizeWeights(NeuralNetwork neuralNetwork);
}

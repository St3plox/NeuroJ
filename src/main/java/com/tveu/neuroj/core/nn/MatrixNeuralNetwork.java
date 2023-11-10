package com.tveu.neuroj.core.nn;

import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.maths.Matrix;
import com.tveu.neuroj.maths.MatrixOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixNeuralNetwork extends AbstractNeuralNetwork {

    protected List<Matrix> connectionWeights;

    protected final double[] input;

    protected AbstractActivationFunction activationFunction;

    public MatrixNeuralNetwork(int inputSize) {
        connectionWeights = new ArrayList<>();
        input = new double[inputSize];
    }

    public MatrixNeuralNetwork(List<Matrix> connectionWeights, double[] input, AbstractActivationFunction activationFunction) {
        this.connectionWeights = connectionWeights;
        this.input = input;
        this.activationFunction = activationFunction;
    }

    public MatrixNeuralNetwork(List<Matrix> connectionWeights, int inputSize, AbstractActivationFunction activationFunction) {

        this(inputSize);

        int connectionsSize = 0;

        for (Matrix matrix : connectionWeights) {
            connectionsSize += matrix.getElementsCount();
        }


        this.connectionWeights = connectionWeights;
        this.activationFunction = activationFunction;
    }

    public AbstractActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(AbstractActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public void addConnectionWeights(double[] values) {
        int lastNeuronsNumber = (connectionWeights.isEmpty()) ? input.length :
                connectionWeights.get(connectionWeights.size() - 1).getElementsCount();

        if (values.length * lastNeuronsNumber < lastNeuronsNumber)
            throw new IllegalArgumentException("weights amount must be greater or equal" +
                    " than neurons number of the last layer");

        Matrix valuesVector = new Matrix(new double[][]{values});
        connectionWeights.add(valuesVector);
    }

    public void addConnectionWeights(int neuronsCount) {

        int lastNeuronsNumber = (connectionWeights.isEmpty()) ? input.length :
                connectionWeights.get(connectionWeights.size() - 1).getElementsCount();

        double[] values = new double[neuronsCount * lastNeuronsNumber];
        Arrays.setAll(values, v -> new Random().nextDouble() * 0.5);
        addConnectionWeights(values);
    }

    @Override
    public void calculateOutput() {
        if (connectionWeights.isEmpty())
            throw new IllegalArgumentException("connectionWeights are empty");

        Matrix currentInput = new Matrix(1, input.length, new double[][]{input});

        for (Matrix weights : connectionWeights) {
            Matrix weightedSum = MatrixOperations.multiply(currentInput, weights);

            double[][] activatedValues = new double[weightedSum.getRows()][weightedSum.getCols()];
            for (int i = 0; i < weightedSum.getRows(); i++) {
                for (int j = 0; j < weightedSum.getCols(); j++) {
                    activatedValues[i][j] = activationFunction.getOutput(weightedSum.getValue(i, j));
                }
            }

            currentInput = new Matrix(activatedValues);
        }

        // Sum up the final result
        output = 0;
        for (double num : currentInput) {
            output += num;
        }

    }

    @Override
    public void setInputVector(double[] inputVector) {
        if (inputVector.length != input.length)
            throw new IllegalArgumentException("Incompatible length of input vector \n" +
                    "Must be " + input.length);

        System.arraycopy(inputVector, 0, input, 0, inputVector.length);
    }


}
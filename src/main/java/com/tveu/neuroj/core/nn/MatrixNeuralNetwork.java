package com.tveu.neuroj.core.nn;

import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.maths.Matrix;
import com.tveu.neuroj.maths.MatrixOperations;

import java.util.List;

public class MatrixNeuralNetwork extends AbstractNeuralNetwork {

    private List<Matrix> connectionWeights;

    private double[] input;

    private AbstractActivationFunction activationFunction;

    public MatrixNeuralNetwork(List<Matrix> connectionWeights, double[] input, AbstractActivationFunction activationFunction) {
        super();

        this.connectionWeights = connectionWeights;
        this.input = input;
        this.activationFunction = activationFunction;
    }

    public MatrixNeuralNetwork(List<Matrix> connectionWeights, int inputSize, AbstractActivationFunction activationFunction) {
        super();
        input = new double[inputSize];

        int connectionsSize = 0;

        for (Matrix matrix : connectionWeights) {
            connectionsSize += matrix.getElementsCount();
        }


        this.connectionWeights = connectionWeights;
        this.activationFunction = activationFunction;
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

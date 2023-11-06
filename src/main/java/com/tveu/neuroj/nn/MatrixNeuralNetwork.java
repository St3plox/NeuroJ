package com.tveu.neuroj.nn;

import com.tveu.neuroj.core.function.AbstractActivationFunction;
import com.tveu.neuroj.maths.Matrix;
import com.tveu.neuroj.maths.MatrixOperations;

import java.util.Arrays;
import java.util.List;

public class MatrixNeuralNetwork extends AbstractNeuralNetwork {

    private final List<Matrix> connectionWeights;

    private final double[] input;

    private final AbstractActivationFunction activationFunction;

    public MatrixNeuralNetwork(List<Matrix> connectionWeights, double[] input, AbstractActivationFunction activationFunction) {
        super();
        this.connectionWeights = connectionWeights;
        this.input = input;
        this.activationFunction = activationFunction;
    }

    public MatrixNeuralNetwork(List<Matrix> connectionWeights, int inputSize,  AbstractActivationFunction activationFunction) {
        super();
        input = new double[inputSize];

        int connectionsSize = 0;

        for (Matrix matrix : connectionWeights) {
            connectionsSize += matrix.getElementsCount();
        }

        if (connectionsSize != countTotalConnections())
            throw new IllegalArgumentException("Amount of connections " +
                    "is not equal to collection number" +
                    " in fully connected neural network");

        this.connectionWeights = connectionWeights;
        this.activationFunction = activationFunction;
    }


    public int countTotalConnections() {
        int count = 0;

        for (int i = 0; i < layers.size() - 1; i++) {
            count += layers.get(i).getNeurons().size()
                    * layers.get(i + 1).getNeurons().size();
        }

        return count;
    }

    public void calculateOutput() {
        if (connectionWeights.isEmpty())
            throw new IllegalArgumentException("connectionWeights are empty");

        Matrix inputMatrix = new Matrix(1, input.length, new double[][]{input});

        Matrix sum = MatrixOperations.multiply(connectionWeights.get(0), (inputMatrix));

        double[] sumOut = new double[sum.getElementsCount()];

        int i = 0;
        for(double num : sum){
            sumOut[i] = activationFunction.getOutput(num);
            i++;
        }
        Matrix out = new Matrix(1, sumOut.length, new double[][]{sumOut});
    }

    @Override
    public void setInputVector(double[] inputVector) {
        if (inputVector.length != input.length)
            throw new IllegalArgumentException("Incompatible length of input vector \n" +
                    "Must be " + input.length);

        System.arraycopy(inputVector, 0, input, 0, inputVector.length);
    }


}

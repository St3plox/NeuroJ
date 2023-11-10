package com.tveu.neuroj;

import com.tveu.neuroj.core.factory.MatrixNeuralNetworkFactory;
import com.tveu.neuroj.core.nn.MatrixNeuralNetwork;
import com.tveu.neuroj.core.nn.NeuralNetwork;
import com.tveu.neuroj.core.factory.NeuralNetworkFactory;
import com.tveu.neuroj.core.function.TanhFunction;
import com.tveu.neuroj.core.train.NeuralNetworkTrainer;
import com.tveu.neuroj.core.train.learning.BackPropagation;
import com.tveu.neuroj.data.DataLoader;
import com.tveu.neuroj.data.DefaultDataLoader;
import com.tveu.neuroj.data.TrainingData;

public class MAin {

    public static void main(String[] args) {

        NeuralNetwork neuralNetwork = new NeuralNetworkFactory()
                .addInputLayer(3)
                .addOutputLayer(1, new TanhFunction())
                .build();

        MatrixNeuralNetwork matrixNeuralNetwork = new MatrixNeuralNetworkFactory(3)
                .addHiddenLayer(2, new TanhFunction())
                .addOutputLayer(1, new TanhFunction())
                .build();

        double[] inputVector = new double[]{-1, -1, -1};
        matrixNeuralNetwork.setInputVector(inputVector);
        matrixNeuralNetwork.calculateOutput();
        System.out.println(matrixNeuralNetwork.getOutput());
/*
        double[][] trainingArray = new double[][]{
                {-1, -1, -1},
                {-1, -1, 1},
                {-1, 1, -1},
                {-1, 1, 1},
                {1, -1, -1},
                {1, -1, 1},
                {1, 1, -1},
                {1, 1, 1},

        };
        double[] trainingResults = new double[]{
                -1, 1, -1, 1, -1, 1, -1, -1
        };

        DataLoader dataLoader = new DefaultDataLoader();
        TrainingData trainingData = dataLoader.loadPreparedData(trainingArray, trainingResults);

        NeuralNetworkTrainer neuralNetworkTrainer =
                new NeuralNetworkTrainer(neuralNetwork, new BackPropagation(0.01));

        neuralNetworkTrainer.train(trainingData, 100);


        double[][] validationArray = new double[][]{
                {-1, -1, -1},
                {-1, -1, 1},
                {-1, 1, -1},
                {-1, 1, 1},
                {1, -1, -1},
                {1, -1, 1},
                {1, 1, -1},
                {1, 1, 1},
        };
        double[] validationResult = new double[]{
                -1, 1, -1, 1, -1, 1, -1, -1
        };

        double threshold = 0.0001; // Adjust the threshold based on your needs

        for (int i = 0; i < validationArray.length; i++) {
            neuralNetwork.setInputVector(validationArray[i]);
            neuralNetwork.calculateOutput();

            double output = neuralNetwork.getOutput();
            boolean isCorrect = Math.abs(output - validationResult[i]) < threshold;

            System.out.println(output + " " + isCorrect);
        }*/
    }
}

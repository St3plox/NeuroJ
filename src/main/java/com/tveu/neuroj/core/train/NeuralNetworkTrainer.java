package com.tveu.neuroj.core.train;

import com.tveu.neuroj.core.nn.NeuralNetwork;
import com.tveu.neuroj.core.train.learning.LearningAlgorithm;
import com.tveu.neuroj.data.TrainingData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

public class NeuralNetworkTrainer {


    private final NeuralNetwork neuralNetwork;

    private final LearningAlgorithm learningAlgorithm;

    public NeuralNetworkTrainer(NeuralNetwork neuralNetwork, LearningAlgorithm learningAlgorithm) {
        this.neuralNetwork = neuralNetwork;
        this.learningAlgorithm = learningAlgorithm;
    }

    public void train(TrainingData trainingData, int epochs){
        Iterator<Entry<double[], Double>> iterator = trainingData.iterator();
        ArrayList<Entry<double[], Double>> entries = new ArrayList<>();

        // Convert the iterator to a list
        while (iterator.hasNext()) {
            entries.add(iterator.next());
        }

        for (int epoch = 0; epoch < epochs; epoch++) {
            // Shuffle the entries
            Collections.shuffle(entries);

            double error = 0;

            for (Entry<double[], Double> entry : entries) {
                neuralNetwork.setInputVector(entry.getKey());
                neuralNetwork.calculateOutput();
                error = neuralNetwork.getOutput() - entry.getValue();
                learningAlgorithm.setError(error);

                learningAlgorithm.optimizeWeights(neuralNetwork);
            }

            System.out.println("Epoch " + epoch + ", error: " + error);
            System.out.println(neuralNetwork.getOutput());
        }

    }
}
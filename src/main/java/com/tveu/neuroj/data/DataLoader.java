package com.tveu.neuroj.data;

import java.util.HashMap;
import java.util.Map;

public interface DataLoader {

    default TrainingData loadPreparedData(double[][] inputData, double[] results) {
        if (inputData.length != results.length)
            throw new IllegalArgumentException("Amount of rows in input data must be equal to results amount");

        Map<double[], Double> trainingMap = new HashMap<>();
        for (int i = 0; i < inputData.length; i++){
            trainingMap.put(inputData[i], results[i]);
        }

        return new TrainingData(trainingMap);
    }
}

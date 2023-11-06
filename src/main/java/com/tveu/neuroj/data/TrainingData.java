package com.tveu.neuroj.data;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TrainingData  implements Iterable<Entry<double[], Double>>{

    //<Input vector, result>
    private Map<double[], Double> trainingMap;


    public TrainingData() {
    }

    public TrainingData(Map<double[], Double> trainingMap) {
        this.trainingMap = trainingMap;
    }


    @Override
    public Iterator<Entry<double[], Double>> iterator() {
        return trainingMap.entrySet().iterator();
    }
}
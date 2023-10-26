package com.tveu.neuroj.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Layer implements Iterable<Neuron> {

    protected String layerLabel;

    protected final List<Neuron> neurons;

    public Layer() {
        neurons = new ArrayList<>();
    }

    public Layer(int neuronsAmount) {
        this.neurons = new ArrayList<>(neuronsAmount);

        for (int i = 0; i < neuronsAmount; i++) {
            Neuron neuron = new Neuron(this);
            neurons.add(neuron);
        }
    }
    public List<Neuron> getNeurons() {
        return new ArrayList<>(neurons);
    }

    public Neuron getNeuronAt(int index){
        return neurons.get(index);
    }

    public String getLayerLabel() {
        return layerLabel;
    }

    public void setLayerLabel(String layerLabel) {
        this.layerLabel = layerLabel;
    }

    public void removeNeuronAt(int index){
        neurons.remove(index);
    }

    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }

    public void clear(){
        neurons.clear();
    }

    public void connectAllNeuronsTo(Layer layer, Weight weight){
        for(Neuron neuron : this){
            for(Neuron anotherLayerNeuron : layer){

                Connection connection = new Connection(neuron, anotherLayerNeuron, weight);
                neuron.addOutputConnection(connection);
            }
        }
    }

    public void connectAllNeuronsTo(Layer layer){
        for(Neuron neuron : this){
            for(Neuron anotherLayerNeuron : layer){

                Connection connection = new Connection(neuron, anotherLayerNeuron);
                neuron.addOutputConnection(connection);
            }
        }
    }



    @Override
    public Iterator<Neuron> iterator() {
        return new LayerIterator();
    }

    private class LayerIterator implements Iterator<Neuron> {
        private final Iterator<Neuron> neuronIterator = neurons.iterator();

        @Override
        public boolean hasNext() {
            return neuronIterator.hasNext();
        }

        @Override
        public Neuron next() {
            return neuronIterator.next();
        }
    }
}

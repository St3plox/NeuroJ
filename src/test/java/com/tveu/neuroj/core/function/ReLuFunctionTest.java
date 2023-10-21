package com.tveu.neuroj.core.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReLuFunctionTest {


    @Test
    void getOutput_positiveInput_returnsInput() {
        ReLuFunctionAbstract reluFunction = new ReLuFunctionAbstract();

        double output = reluFunction.getOutput(5.0);

        assertEquals(5.0, output, 1e-9);
    }

    @Test
    void getOutput_negativeInput_returnsZero() {
        ReLuFunctionAbstract reluFunction = new ReLuFunctionAbstract();

        double output = reluFunction.getOutput(-3.0);

        assertEquals(0.0, output, 1e-9);
    }

    @Test
    void getOutput_zeroInput_returnsZero() {
        ReLuFunctionAbstract reluFunction = new ReLuFunctionAbstract();

        double output = reluFunction.getOutput(0.0);

        assertEquals(0.0, output, 1e-9);
    }

    @Test
    void getDerivative_positiveInput_returnsOne() {
        ReLuFunctionAbstract reluFunction = new ReLuFunctionAbstract();

        double derivative = reluFunction.getDerivative(2.0);

        assertEquals(1.0, derivative, 1e-9);
    }

    @Test
    void getDerivative_negativeInput_returnsZero() {
        ReLuFunctionAbstract reluFunction = new ReLuFunctionAbstract();

        double derivative = reluFunction.getDerivative(-1.0);

        assertEquals(0.0, derivative, 1e-9);
    }

    @Test
    void getDerivative_zeroInput_returnsZero() {
        ReLuFunctionAbstract reluFunction = new ReLuFunctionAbstract();

        double derivative = reluFunction.getDerivative(0.0);

        assertEquals(0.0, derivative, 1e-9);
    }
}
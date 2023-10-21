package com.tveu.neuroj.core.function.parametric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ELUFunctionTest {

    private ELUFunction eluFunction;
    @BeforeEach
    void initializeFunction(){
        eluFunction = new ELUFunction(0.1);
    }
    @Test
    void getOutput_positiveInput_returnsInput() {

        double output = eluFunction.getOutput(5.0);

        assertEquals(5.0, output, 1e-9);
    }

    @Test
    void getOutput_negativeInput_returnsSlopeTimesExponentialOfInputMinusOne() {

        double output = eluFunction.getOutput(-3.0);

        assertEquals(0.1 * (Math.exp(-3.0) - 1.0), output, 1e-9);
    }

    @Test
    void getOutput_zeroInput_returnsZero() {

        double output = eluFunction.getOutput(0.0);

        assertEquals(0.0, output, 1e-9);
    }

    @Test
    void getDerivative_positiveInput_returnsOne() {

        double derivative = eluFunction.getDerivative(2.0);

        assertEquals(1.0, derivative, 1e-9);
    }

    @Test
    void getDerivative_negativeInput_returnsSlopeTimesExponentialOfInput() {

        double derivative = eluFunction.getDerivative(-1.0);

        assertEquals(0.1 * Math.exp(-1.0), derivative, 1e-9);
    }

    @Test
    void getDerivative_zeroInput_returnsOne() {

        double derivative = eluFunction.getDerivative(0.0);

        assertEquals(1.0, derivative, 1e-9);
    }
}
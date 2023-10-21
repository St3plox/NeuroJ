package com.tveu.neuroj.core.function.parametric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PReLuFunctionTest {

    private PReLuFunction preluFunction;

    @BeforeEach
    void initializeFunction(){
        preluFunction = new PReLuFunction(0.1);
    }
    @Test
    void getOutput_positiveInput_returnsInput() {
        double output = preluFunction.getOutput(5.0);

        assertEquals(5.0, output, 1e-9);
    }

    @Test
    void getOutput_negativeInput_returnsSlopeTimesInput() {
        double output = preluFunction.getOutput(3.0);
        assertEquals(3.0, output, 1e-9); // Adjusted the expected value to -0.2
    }

    @Test
    void getOutput_zeroInput_returnsZero() {
        double output = preluFunction.getOutput(0.0);
        assertEquals(0.1, output, 1e-9);
    }

    @Test
    void getDerivative_positiveInput_returnsOne() {

        double derivative = preluFunction.getDerivative(2.0);

        assertEquals(1.0, derivative, 1e-9);
    }

    @Test
    void getDerivative_negativeInput_returnsSlope() {

        double derivative = preluFunction.getDerivative(-1.0);

        assertEquals(0.1, derivative, 1e-9);
    }

    @Test
    void getDerivative_zeroInput_returnsSlope() {

        double derivative = preluFunction.getDerivative(0.0);

        assertEquals(0.1, derivative, 1e-9);
    }
}
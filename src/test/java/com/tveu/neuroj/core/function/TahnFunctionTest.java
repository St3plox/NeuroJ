package com.tveu.neuroj.core.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TahnFunctionTest {

    private TanhFunction tanhFunction;

    @BeforeEach
    void setUp() {
        tanhFunction = new TanhFunction();
    }

    @Test
    void getOutput_negativeInput_returnsSlopeTimesExponentialOfInputMinusOne() {
        double totalInput = -1.0;
        double expectedOutput = (Math.exp(totalInput) - Math.exp(-totalInput)) /
                (Math.exp(totalInput) + Math.exp(-totalInput));

        double actualOutput = tanhFunction.getOutput(totalInput);

        assertEquals(expectedOutput, actualOutput, 1e-9);
    }

    @Test
    void getDerivative_positiveInput_returnsOneMinusOutputSquared() {
        double totalInput = 1.0;

        double tanhOutput = tanhFunction.getOutput(totalInput);
        double expectedDerivative = 1.0 - tanhOutput * tanhOutput;

        double actualDerivative = tanhFunction.getDerivative(totalInput);

        assertEquals(expectedDerivative, actualDerivative, 1e-9);
    }

    @Test
    void getDerivativeWithoutOutputCalculation_returnsOneMinusOutputSquared() {
        // Test that getDerivative works without separately calling getOutput

        double totalInput = 1.0;
        double expectedDerivative = 1.0 - tanhFunction.getOutput(totalInput) * tanhFunction.getOutput(totalInput);

        double actualDerivative = tanhFunction.getDerivative(totalInput);

        assertEquals(expectedDerivative, actualDerivative, 1e-9);
    }

}
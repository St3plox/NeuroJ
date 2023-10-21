package com.tveu.neuroj.core.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SigmoidFunctionTest {

    @Test
    void getOutput_validInput_returnsCorrectOutput() {
        SigmoidFunction sigmoidFunction = new SigmoidFunction();

        double output = sigmoidFunction.getOutput(1.0);

        assertEquals(0.7310585786300049, output, 1e-9);
    }

    @Test
    void getDerivative_validInput_returnsCorrectDerivative() {
        SigmoidFunction sigmoidFunction = new SigmoidFunction();

        double derivative = sigmoidFunction.getDerivative(1.0);

        assertEquals(0.19661193324148185, derivative, 1e-9);
    }

    @Test
    void getDerivative_calledAfterGetOutput_returnsCorrectDerivative() {
        SigmoidFunction sigmoidFunction = new SigmoidFunction();

        sigmoidFunction.getOutput(1.0);
        double derivative = sigmoidFunction.getDerivative(1.0);

        assertEquals(0.19661193324148185, derivative, 1e-9);
    }
}
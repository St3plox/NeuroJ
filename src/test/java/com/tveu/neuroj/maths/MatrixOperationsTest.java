package com.tveu.neuroj.maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixOperationsTest {

    private Matrix matrix1;
    private Matrix matrix2;

    @BeforeEach
    void setUp() {
        // Create matrices for testing
        double[][] arr1 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        double[][] arr2 = {
                {2.0, 0.0, 1.0},
                {1.0, 2.0, 3.0},
                {0.0, 1.0, 2.0}
        };

        matrix1 = new Matrix(3, 3, arr1);
        matrix2 = new Matrix(3, 3, arr2);
    }

    @Test
    void multiply_compatibleMatrices_returnsCorrectResult() {
        Matrix result = MatrixOperations.multiply(matrix1, matrix2);

        // Check a few values in the result matrix
        assertEquals(4.0, result.getValue(0, 0));
        assertEquals(16.0, result.getValue(1, 1));
        assertEquals(49, result.getValue(2, 2));
    }

    @Test
    void multiply_incompatibleMatrices_throwsException() {
        Matrix matrix3 = new Matrix(2, 2); // Different dimensions
        assertThrows(IllegalArgumentException.class, () -> MatrixOperations.multiply(matrix1, matrix3));
    }

    @Test
    void add_compatibleMatrices_returnsCorrectResult() {
        Matrix result = MatrixOperations.add(matrix1, matrix2);

        // Check a few values in the result matrix
        assertEquals(3.0, result.getValue(0, 0));
        assertEquals(7.0, result.getValue(1, 1));
        assertEquals(11.0, result.getValue(2, 2));
    }

    @Test
    void add_incompatibleMatrices_throwsException() {
        Matrix matrix3 = new Matrix(2, 2); // Different dimensions
        assertThrows(IllegalArgumentException.class, () -> MatrixOperations.add(matrix1, matrix3));
    }
}
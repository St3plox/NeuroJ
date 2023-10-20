package com.tveu.neuroj.maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
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
    void getValue_validIndices_returnsCorrectValue() {
        assertEquals(5.0, matrix1.getValue(1, 1));
    }

    @Test
    void getValue_invalidIndices_throwsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix1.getValue(5, 2));
    }

    @Test
    void setValue_validIndices_setsCorrectValue() {
        matrix1.setValue(1, 1, 10.0);
        assertEquals(10.0, matrix1.getValue(1, 1));
    }

    @Test
    void setValue_invalidIndices_throwsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix1.setValue(5, 2, 10.0));
    }

    @Test
    void transpose_validMatrix_correctTranspose() {
        matrix1.transpose();
        assertEquals(7.0, matrix1.getValue(0, 2));
    }

    @Test
    void canMultiply_compatibleMatrices_returnsTrue() {
        assertTrue(matrix1.canMultiply(matrix2));
    }

    @Test
    void canMultiply_incompatibleMatrices_returnsFalse() {
        Matrix matrix3 = new Matrix(2, 2); // Different dimensions
        assertFalse(matrix1.canMultiply(matrix3));
    }

    @Test
    void canAdd_compatibleMatrices_returnsTrue() {
        assertTrue(matrix1.canAdd(matrix2));
    }

    @Test
    void canAdd_incompatibleMatrices_returnsFalse() {
        Matrix matrix3 = new Matrix(2, 2); // Different dimensions
        assertFalse(matrix1.canAdd(matrix3));
    }
}
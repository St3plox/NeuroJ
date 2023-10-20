package com.tveu.neuroj.maths;

public class MatrixOperations {

    public static Matrix multiply(Matrix m1, Matrix m2) {

        if (!m1.canMultiply(m2))
            throw new IllegalArgumentException("Incompatible matrices for multiplication");

        Matrix result = new Matrix(m1.getRows(), m2.getCols());  // Use the number of columns from m2

        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m2.getCols(); j++) {

                double sum = 0.0;

                for (int k = 0; k < m1.getCols(); k++) {  // Use the number of columns from m1
                    sum += m1.getValue(i, k) * m2.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }

        return result;
    }

    public static Matrix add(Matrix m1, Matrix m2) {

        if (!m1.canAdd(m2))
            throw new IllegalArgumentException("Incompatible matrices for addition");

        Matrix result = new Matrix(m1.getRows(), m1.getCols());

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getCols(); j++) {

                result.setValue(
                        i,
                        j,
                        m1.getValue(i, j) + m2.getValue(i, j)
                );
            }
        }

        return result;
    }

}

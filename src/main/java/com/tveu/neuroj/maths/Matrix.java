package com.tveu.neuroj.maths;

import java.util.*;

public class Matrix implements Iterable<Double> {

    private int rows;

    private int cols;

    protected List<Double> matrix;

    public Matrix(int rows, int cols, double[][] arr) {

        this.rows = rows;
        this.cols = cols;

        matrix = new ArrayList<>(rows * cols);

        Arrays.stream(arr)
                .flatMapToDouble(Arrays::stream)
                .forEach(matrix::add);
    }

    public Matrix(int rows, int cols) {
        this(rows, cols, new double[rows][cols]);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double getValue(int row, int col) {

        int index = getIndex(row, col);
        outOfBounceCheck(index);

        return matrix.get(index);
    }

    public void setValue(int row, int col, double value) {

        int index = getIndex(row, col);
        outOfBounceCheck(index);

        matrix.set(index, value);
    }

    public void transpose() {
        List<Double> transposedMatrix = new ArrayList<>(matrix);

        int transposedRows = cols;
        int transposedCols = rows;

        matrix.clear();

        for (int col = 0; col < transposedCols; col++) {
            for (int row = 0; row < transposedRows; row++) {
                int index = getIndex(row, col);
                matrix.add(transposedMatrix.get(index));
            }
        }

        rows = transposedRows;
        cols = transposedCols;
    }


    public boolean canMultiply(Matrix other) {
        return rows == other.cols;
    }

    public boolean canAdd(Matrix other) {
        return (rows == other.rows && cols == other.cols);
    }

    public int getElementsCount() {
        return rows * cols;
    }

    public void dot(Matrix matrix) {
        Matrix result = MatrixOperations.multiply(this, matrix);
        this.matrix = result.matrix;
        this.rows = result.rows;
        this.cols = result.cols;
    }

    public void dot(double scalar) {
        matrix.replaceAll(aDouble -> aDouble * scalar);
    }

    private int getIndex(int row, int col) {
        return cols * row + col;
    }

    private void outOfBounceCheck(int index) {

        if (index > cols * rows) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds of " + cols * rows);
        }
    }

    @Override
    public Iterator<Double> iterator() {
        return new MatrixIterator();
    }

    private class MatrixIterator implements Iterator<Double> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < matrix.size();
        }

        @Override
        public Double next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in the matrix");
            }
            return matrix.get(currentIndex++);
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                stringBuilder.append(this.getValue(i, j));
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }

        return "Matrix {" + "\n" +
                "rows= " + rows +
                ", cols= " + cols + ",\n" +
                "matrix= \n" + stringBuilder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return rows == matrix1.rows && cols == matrix1.cols && Objects.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, matrix);
    }
}
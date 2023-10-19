package com.tveu.neuroj.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix<T extends Number> {

    private int rows;

    private int cols;

    protected final List<T> matrix;

    public Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;

        matrix = new ArrayList<>(rows*cols);
    }

    public Matrix(int rows, int cols, T[][] arr) {
        this(rows, cols);

        Arrays.stream(arr).flatMap(Arrays::stream).forEach(matrix::add);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public T getValue(int row, int col) {

        int index = getIndex(row, col);
        outOfBounceCheck(index);

        return matrix.get(index);
    }

    public void setValue(int row, int col, T value){

        int index = getIndex(row, col);
        outOfBounceCheck(index);

        matrix.set(index, value);
    }

    public void transpose(){
        List<T> transposedMatrix = new ArrayList<>(matrix);

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

    public boolean canMultiply(Matrix<T> other){
        return rows == other.cols;
    }

    public boolean canAdd(Matrix<T> other){
        return (rows == other.rows && cols == other.cols);
    }

    private int getIndex(int row, int col){
        return cols * row + col;
    }
    private void outOfBounceCheck(int index) {

        if (index > cols * rows) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
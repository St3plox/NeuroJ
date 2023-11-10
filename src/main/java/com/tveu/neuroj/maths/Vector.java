package com.tveu.neuroj.maths;

public class Vector extends Matrix {

    public Vector(int size) {
        super(1, size);
    }

    public Vector(double[] arr) {
        super(new double[][]{arr});
    }
}

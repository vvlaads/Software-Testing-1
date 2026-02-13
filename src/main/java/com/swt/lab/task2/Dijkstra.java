package com.swt.lab.task2;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public List<Double> calculate(int pointNumber, double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException();
        }

        if (pointNumber >= matrix.length) {
            throw new IllegalArgumentException();
        }

        List<Double> weights = new ArrayList<>();
        //TODO: алгоритм Дейкстра
        return weights;
    }
}

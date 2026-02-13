package com.swt.lab.task1;

import java.util.HashMap;

public class Arccos {

    private final HashMap<Integer, Double> factorials = new HashMap<>();

    private double factorial(int n) {
        if (n <= 1) return 1.0;

        if (factorials.containsKey(n)) {
            return factorials.get(n);
        }

        double result = n * factorial(n - 1);
        factorials.put(n, result);
        return result;
    }

    public double calculate(double x, int accuracy) throws ArccosArgumentException {
        if (x < -1 || x > 1) {
            throw new ArccosArgumentException();
        }

        if (x == -1) {
            return Math.PI;
        } else if (x == 1) {
            return 0;
        }

        double acc = 0;

        for (int n = 0; n < accuracy; n++) {
            acc += factorial(2 * n) / (Math.pow(4, n) * factorial(n) * factorial(n) * (2 * n + 1)) * Math.pow(x, 2 * n + 1);
        }
        return Math.PI / 2 - acc;
    }

    public double calculate(double x) throws ArccosArgumentException {
        return calculate(x, 50);
    }
}

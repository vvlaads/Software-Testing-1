package com.swt.lab.task2;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public List<Double> calculate(int vertexNumber, double[][] matrix) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException();
        }

        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException();
        }

        int n = matrix.length;
        if (vertexNumber >= n) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i] || matrix[i][j] < 0) {
                    throw new IllegalArgumentException();
                }
            }
        }

        double[] dist = new double[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            visited[i] = false;
        }
        dist[vertexNumber] = 0;

        for (int count = 0; count < n; count++) {
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }
            if (u == -1) break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && matrix[u][v] > 0) {
                    double newDist = dist[u] + matrix[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                    }
                }
            }
        }

        List<Double> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(i, dist[i]);
        }
        return result;
    }
}

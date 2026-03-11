package com.swt.lab.task2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DijkstraTest {

    private final Dijkstra dijkstra = new Dijkstra();
    private final Double INF = Double.POSITIVE_INFINITY;

    private double[][] createMatrix(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = INF;
                if (i == j) {
                    matrix[i][i] = 0;
                }
            }
        }
        return matrix;
    }

    private void addEdge(double[][] matrix, double weight, int i, int j) {
        matrix[i][j] = weight;
        matrix[j][i] = weight;
    }

    @Test
    void testCommonInput() {
        double[][] matrix = createMatrix(3);
        addEdge(matrix, 3, 0, 1);
        List<Double> expected = List.of(0.0, 3.0, INF);
        assertEquals(expected, dijkstra.calculate(0, matrix));
    }

    @Test
    void testIsolatedVertex() {
        double[][] matrix = createMatrix(3);
        addEdge(matrix, 3, 0, 1);
        List<Double> expected = List.of(INF, INF, 0.0);
        assertEquals(expected, dijkstra.calculate(2, matrix));
    }

    @Test
    void testCycle() {
        double[][] matrix = createMatrix(3);
        addEdge(matrix, 5, 0, 1);
        addEdge(matrix, 4, 1, 2);
        addEdge(matrix, 2, 0, 2);
        List<Double> expected = List.of(5.0, 0.0, 4.0);
        assertEquals(expected, dijkstra.calculate(1, matrix));
    }

    @Test
    void testGraphWithLoop() {
        double[][] matrix = createMatrix(1);
        addEdge(matrix, 5, 0, 0);
        List<Double> expected = List.of(0.0);
        assertEquals(expected, dijkstra.calculate(0, matrix));
    }

    @Test
    void testGraphWithLoops() {
        double[][] matrix = createMatrix(4);
        addEdge(matrix, 5, 0, 1);
        addEdge(matrix, 5, 1, 2);
        addEdge(matrix, 5, 2, 3);
        addEdge(matrix, 3, 1, 1);
        addEdge(matrix, 3, 2, 2);
        List<Double> expected = List.of(0.0, 5.0, 10.0, 15.0);
        assertEquals(expected, dijkstra.calculate(0, matrix));
    }

    @Test
    void testSingleVertex() {
        double[][] matrix = createMatrix(1);
        List<Double> expected = List.of(0.0);

        assertEquals(expected, dijkstra.calculate(0, matrix));
    }

    @Test
    void testEmptyGraph() {
        double[][] matrix = new double[0][0];
        assertThrows(IllegalArgumentException.class, () -> dijkstra.calculate(0, matrix));
    }

    @Test
    void testNegativeEdge() {
        double[][] matrix = createMatrix(2);
        addEdge(matrix, -3, 0, 1);

        assertThrows(IllegalArgumentException.class,
                () -> dijkstra.calculate(0, matrix));
    }

    @Test
    void testBadMatrix() {
        double[][] badMatrix = new double[5][4];
        addEdge(badMatrix, 4, 0, 1);
        addEdge(badMatrix, 6, 1, 3);

        assertThrows(IllegalArgumentException.class, () -> dijkstra.calculate(3, badMatrix));
    }

    @Test
    void testAsymmetricMatrix() {
        double[][] matrix = createMatrix(2);
        matrix[0][1] = 5;

        assertThrows(IllegalArgumentException.class,
                () -> dijkstra.calculate(0, matrix));
    }

    @Test
    void testVertexNumberOutOfBounds() {
        double[][] matrix = createMatrix(2);
        assertThrows(IllegalArgumentException.class,
                () -> dijkstra.calculate(2, matrix));
    }

}

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

    @Test
    void testCommonInput() {
        double[][] matrix = createMatrix(8);
        matrix[0][1] = 7;
        matrix[1][0] = 7;
        matrix[1][3] = 6;
        matrix[3][1] = 6;
        matrix[3][5] = 5;
        matrix[5][3] = 5;
        matrix[6][4] = 8;
        matrix[4][6] = 8;
        matrix[5][7] = 9;
        matrix[7][5] = 9;
        List<Double> expected = List.of(13.0, 6.0, INF, 0.0, INF, 5.0, INF, 14.0);
        assertEquals(expected, dijkstra.calculate(3, matrix));
    }

    @Test
    void testIsolatedVertex() {
        double[][] matrix = createMatrix(8);
        matrix[0][1] = 7;
        matrix[1][0] = 7;
        matrix[1][3] = 6;
        matrix[3][1] = 6;
        matrix[3][5] = 5;
        matrix[5][3] = 5;
        matrix[6][4] = 8;
        matrix[4][6] = 8;
        matrix[5][7] = 9;
        matrix[7][5] = 9;
        List<Double> expected = List.of(INF, INF, 0.0, INF, INF, INF, INF, INF);
        assertEquals(expected, dijkstra.calculate(2, matrix));
    }

    @Test
    void testCycle() {
        double[][] matrix = createMatrix(8);
        matrix[1][3] = 8;
        matrix[3][1] = 8;
        matrix[1][5] = 1;
        matrix[5][1] = 1;
        matrix[3][5] = 9;
        matrix[5][3] = 9;
        matrix[3][7] = 1;
        matrix[7][3] = 1;
        matrix[4][7] = 2;
        matrix[7][4] = 2;
        List<Double> expected = List.of(INF, 1.0, INF, 9.0, 12.0, 0.0, INF, 10.0);
        assertEquals(expected, dijkstra.calculate(5, matrix));
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
        matrix[0][1] = -3;
        matrix[1][0] = -3;

        assertThrows(IllegalArgumentException.class,
                () -> dijkstra.calculate(0, matrix));
    }

    @Test
    void testBadMatrix() {
        double[][] badMatrix = new double[5][4];
        badMatrix[0][1] = 4;
        badMatrix[1][0] = 4;
        badMatrix[1][3] = 6;
        badMatrix[3][1] = 6;

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

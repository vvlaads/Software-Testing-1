package com.swt.lab.task1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArccosTest {
    private static final Random random = new Random(42);
    private static final Arccos arccos = new Arccos();

    @Test
    void testRange() {
        assertThrows(IllegalArgumentException.class, () -> arccos.calculate(1 + random.nextDouble()));
        assertThrows(IllegalArgumentException.class, () -> arccos.calculate(-1 - random.nextDouble()));
    }

    @Test
    void testBorderPoints() {
        double eps = 1e-6;
        assertEquals(Math.PI, arccos.calculate(-1), eps);
        assertEquals(Math.PI / 2, arccos.calculate(0), eps);
        assertEquals(0, arccos.calculate(1), eps);
    }

    @Test
    void testInsideInterval() {
        double eps = 1e-6;

        assertEquals(Math.PI * 2 / 3, arccos.calculate(-0.5), eps);
        assertEquals(Math.PI / 3, arccos.calculate(0.5), eps);
    }
}

package com.swt.lab.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArccosTest {
    private static final Arccos arccos = new Arccos();

    @Test
    void testRange() {
        double eps = 1e-6;
        assertThrows(ArccosArgumentException.class, () -> arccos.calculate(1 + eps));
        assertThrows(ArccosArgumentException.class, () -> arccos.calculate(-1 - eps));
    }

    @Test
    void testBorderPoints() {
        double eps = 1e-6;
        try {
            assertEquals(Math.PI, arccos.calculate(-1), eps);
            assertEquals(Math.PI / 2, arccos.calculate(0), eps);
            assertEquals(0, arccos.calculate(1), eps);
        } catch (ArccosArgumentException ignored) {
        }
    }

    @Test
    void testInsideInterval() {
        double eps = 1e-6;
        try {
            assertEquals(Math.PI * 2 / 3, arccos.calculate(-0.5), eps);
            assertEquals(Math.PI / 3, arccos.calculate(0.5), eps);
        } catch (ArccosArgumentException ignored) {
        }
    }
}

package com.swt.lab.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArccosTest {
    private static final Arccos arccos = new Arccos();
    private static final double eps = 1e-6;

    @ParameterizedTest
    @CsvSource({
            "-1, 3.141592653589793",
            "0, 1.5707963267948966",
            "1, 0"
    })
    void testBorderPoints(double input, double expected) throws ArccosArgumentException {
        assertEquals(expected, arccos.calculate(input), eps);
    }

    @ParameterizedTest
    @CsvSource({
            "-0.5, 2.0943951023931957",
            "0.5, 1.0471975511965979"
    })
    void testInsideInterval(double input, double expected) throws ArccosArgumentException {
        assertEquals(expected, arccos.calculate(input), eps);
    }
}
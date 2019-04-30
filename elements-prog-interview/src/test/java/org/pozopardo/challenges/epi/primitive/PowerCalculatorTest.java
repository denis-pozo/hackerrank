package org.pozopardo.challenges.epi.primitive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerCalculatorTest {

    @Test
    public void anythingPowerZeroShouldReturnOne() {
        assertEquals(1, PowerCalculator.calculate(234, 0), 0.0);
    }

    @Test
    public void powerBaseOneAlwaysOne() {
        assertEquals(1, PowerCalculator.calculate(1, 18), 0.0);
    }

    @Test
    public void testingSomePowers() {
        assertEquals(Math.pow(5,34), PowerCalculator.calculate(5,34), 0.0);
        assertEquals(Math.pow(2, 36), PowerCalculator.calculate(2, 36), 0.0);
//        assertEquals(Math.pow(23.8, 5), PowerCalculator.calculate(23.8, 5), 0.0);
//        assertEquals(Math.pow(99,3), PowerCalculator.calculate(99,3), 0.0);
//        assertEquals(Math.pow(311.003, 45), PowerCalculator.calculate(311.003, 45), 0.0);
    }


}

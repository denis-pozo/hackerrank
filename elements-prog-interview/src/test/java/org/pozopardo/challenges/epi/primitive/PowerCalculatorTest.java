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
        // XXX Still some accuracy issues comparing with Math function
        assertEquals(Math.pow(5, 10), PowerCalculator.calculate(5,10), 0.0001);
        assertEquals(Math.pow(2, 5), PowerCalculator.calculate(2, 5), 0.0001);
        assertEquals(Math.pow(99, 3), PowerCalculator.calculate(99,3), 0.0001);
    }


}

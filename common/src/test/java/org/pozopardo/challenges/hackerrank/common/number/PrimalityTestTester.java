package org.pozopardo.challenges.hackerrank.common.number;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PrimalityTestTester {

        private static final Object[] getPrimes() {
                return new Object[]{
                        new Object[]{"2"},
                        new Object[]{"3"},
                        new Object[]{"5"},
                        new Object[]{"7"},
                        new Object[]{"11"},
                        new Object[]{"13"},
                        new Object[]{"17"},
                        new Object[]{"19"},
                        new Object[]{"37"},
                        new Object[]{"47"},
                        new Object[]{"73"},
                        new Object[]{"101"},
                        new Object[]{"131"},
                        new Object[]{"157"},
                        new Object[]{"163"},
                        new Object[]{"199"}
                };
        }

        @Test
        @Parameters(method = "getPrimes")
        public void isPrimeShouldReturnTrue(String integer) {
            assertTrue(PrimalityTest.isPrime(integer));
        }

        @Test
        public void isPrimeShouldReturnFalseWithNoPrimeNumbers() {
            assertFalse(PrimalityTest.isPrime(
                    "8306193547961364862906443093104785840173353478461"));
        }

}

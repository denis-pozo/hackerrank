package org.pozopardo.epi.primitive;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ParityCheckerTest {

    private static final long X = 21;

    @Test
    public void evenParityShouldReturnTrue() {

        assertTrue(ParityChecker.isParityOneImproved(X));
    }
}

package org.pozopardo.challenges.hackerrank.data.structure;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(JUnitParamsRunner.class)
public class BalancedStringCheckerTest {

    private static final Object[] getBalancedString() {
        return new Object[]{
                new Object[]{"{}()"},
                new Object[]{"[{()}]"},
                new Object[]{"({()})"}
        };
    }

    private static final Object[] getUnbalancedString() {
        return new Object[]{
                new Object[]{"{}("},
                new Object[]{"({}}"},
                new Object[]{"}{"}
        };
    }

    @Test
    @Parameters(method = "getBalancedString")
    public void isBalancedShouldBeTrueWhenBalancedStrings(String string) {
        assertTrue(BalancedStringChecker.isBalanced(string));
    }

    @Test
    @Parameters(method = "getUnbalancedString")
    public void isBalancedShouldBeFalseWhenUnbalancedStrings(String string) {
        assertFalse(BalancedStringChecker.isBalanced(string));
    }
}

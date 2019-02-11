package org.pozopardo.hackerrank.array;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pozopardo.hackerrank.number.PrimalityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ArrayGameTest {

    private static final Object[] getGameAndLeap() {
        return new Object[]{
                new Object[]{new int[]{0, 0, 0, 0, 0}, 3, true},
                new Object[]{new int[]{0, 0, 0, 1, 1}, 5, true},
                new Object[]{new int[]{0, 0, 1, 1, 1, 0}, 3, false},
                new Object[]{new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1}, 4, true},
                new Object[]{new int[]{0, 1, 0}, 1, false}
        };
    }

    @Test
    @Parameters(method = "getGameAndLeap")
    public void checkCanWin(int [] game, int leap, boolean result) {

        assertEquals(result, ArrayGame.canWin(leap, game));
    }

}

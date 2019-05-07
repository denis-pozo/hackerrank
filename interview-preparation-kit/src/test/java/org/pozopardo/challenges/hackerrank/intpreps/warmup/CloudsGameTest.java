package org.pozopardo.challenges.hackerrank.intpreps.warmup;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CloudsGameTest {

    private static final Object[] getGameCases() {
        return new Object[]{
                new Object[]{new int[]{0, 0, 1, 0, 0, 1, 0}, 4},
                new Object[]{new int[]{0, 0, 0, 1, 0, 0}, 3},
                new Object[]{new int[]{0, 0, 0, 0, 1, 0}, 3}
        };
    }

    @Test
    @Parameters(method = "getGameCases")
    public void parametricTestWithHackerRankCases(int [] clouds, int result) {
        assertEquals(result, CloudsGame.jumpingOnClouds(clouds));
    }
}

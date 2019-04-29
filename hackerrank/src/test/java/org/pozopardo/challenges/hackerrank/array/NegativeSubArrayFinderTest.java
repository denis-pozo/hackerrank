package org.pozopardo.challenges.hackerrank.array;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NegativeSubArrayFinderTest {

    private static final Object[] getArraysUnderTest() {
        return new Object[]{
                new Object[]{new Integer[] {1,-2,4,-5,1}, 9},
                new Object[]{new Integer[] {-100}, 1},
                new Object[]{new Integer[] {100}, 0},
                new Object[]{new Integer[] {255, -77, 601, 89, -993, -307, 300,
                                            452, -312, 400, -993, 831, 790, 236,
                                            981, 274, 167, 676, -134, -906, 139,
                                            -537, -159, 483, 398, 253, 583, 348,
                                            582, 481, 398, -504, 459, 39, 650,
                                            424, 511, 581, 303, 142, -300, 796,
                                            183, -609, 432, 33, -846, -101, 421,
                                            602, -789, 214, 692, -971, 212, 752,
                                            -564, -747, -396, 217, 448, 364, -139,
                                            304, -309, 337, 989, 751, 698, 381,
                                            892, -774, 34, 557, 231, 612, -377,
                                            -677, 497, -781, -944, 608, 21, 967,
                                            787, -334, 835, 136, 335, -4, -468,
                                            -301, -296, 65, -664, -303, 317, 893,
                                            624, 115}, 425}
        };
    }

    @Test
    @Parameters(method = "getArraysUnderTest")
    public void unorderedInputArrayShouldCountSameNegativeSubarrays
            (Integer [] array, int result)
    {
        assertEquals(
                result,
                NegativeSubArrayFinder.countTotalNegativeSubarrays(array)
        );
    }

}


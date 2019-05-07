package org.pozopardo.challenges.hackerrank.intpreps.warmup;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class HikingAssistantTest {

    private static final Object[] getHikkingRoutes() {
        return new Object[]{
                new Object[]{12, "DDUUDDUDUUUD", 2},
                new Object[]{8, "UDDDUDUU", 1},
                new Object[]{1000, "UDDDUUDUUDDDDUUDDUDDDUUDDDUUDDUUDUDUDDDDUUDD" +
                        "DDDDUUUDUDUDUUDUUUUUUUUUUUDUUUUUDUDUDUDDDDUUDUUUDDDDDUU" +
                        "DUUDUUUUUUDDDDDUUDUUDDDUDUUUUUUUDUUUUDDUDDDDDUUUDDUUUUU" +
                        "UUDDDDUUUDUUUDUUUUUUUDDUUUDDDDUUDUDDDUDDDDUUDDDDDUUDUDD" +
                        "UDUUUDDUDUDDDUUDDUDUUUUUDDUUUDUUUUUUDDUDUUDDUUDDDUDUDDD" +
                        "DUDUDDUUUDDDUDDUDDUUUUDDDUDUDDDUUUUUDUUUDDUDUUDUUUDDUDU" +
                        "UUDUDUDUUUUDDUDDDUUUDDDUDUDDDDDDDUUUUDDUUDUUUDUDUDUDDUU" +
                        "UDDUDUDDUDDUDDDUDUDUDDUUDDDUUDUUDUDDDDDDDDUUDDUUDDUUUUU" +
                        "UDUUUDDUUDUDDUUDDDUDDUUUUUDUDUDDDUUUDDUUDDDUDUUDUUDDDUD" +
                        "DUUDUUUDDUUUUDUUUDDDDUDUUUDDUDDDDDDDUDDDUUDUDDUDUDUUDUD" +
                        "DUUDUUDUUDUUDUDDDUUDDUUUUDUUDUUDUUUUDUUUDDUUUDDUDUDDUDU" +
                        "DUUUDUDDDUUUUDUUDUUUDDUUDUDUDDDDUDUDDDDDUUUDUUUDUDDUUUD" +
                        "UUUUDDUUUDDDUDUDUUDUUUUUDUUDDDUUDDUDDDDUUUDUUUUUDDUUUUU" +
                        "DDUUDUDDUDUDUUUUDUUDUUUDUUDDDUUUUDDDUDUDUUDUDUUDDDUDDUU" +
                        "DDUDUDUUDUDUDDDUDDDUDDDDUDUUUUUDUDUDUUDUUDUDDUDUUDDUUDU" +
                        "DUDDDDUDDUDDUDDUUUUDUDDUUUUDUUDUDDUDDDUDUUUDUDUDUDDDUDD" +
                        "UUUUDDUDUDUDDUDDDUDDDUUUDUDUDUUDUUUUUDUDDDDUUDDDDUDUDDU" +
                        "DDDDUUUDUDUUDUDUUUDDUDUDDDDDUUDUDUUDDDDUUDDDDDDDDDDDDDD" +
                        "DDDDDDDDDDDDDDDDDDDDD", 3}
        };
    }

    @Test
    @Parameters(method = "getHikkingRoutes")
    public void parametricTestWithHackerRankCases(int nSteps, String route, int result) {
        assertEquals(result, HikingAssistant.countingValleys(nSteps, route));
    }
}

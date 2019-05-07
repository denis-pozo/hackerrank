package org.pozopardo.challenges.hackerrank.common.number;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class BigDecimalSorterTest {



    @Test
//    @Parameters(method = "getTestStrings")
    public void testSortBigInteger() {
        String [] input = new String []{
                "-100",
                "50",
                "0",
                "56.6",
                "90",
                "0.12",
                ".12",
                "02.34",
                "000.000"};

        String [] expected = new String [] {
                "90",
                "56.6",
                "50",
                "02.34",
                "0.12",
                ".12",
                "0",
                "000.000",
                "-100"};

       BigDecimalSorter.sortBigDecimal(input);
       assertArrayEquals(expected, input);
    }
}

package org.pozopardo.challenges.hackerrank.intpreps.warmup;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class InfiniteStringCounterTest {

    final static private String USECASE_FILENAME = "/infinite-string-case7.txt";

    private static final Object[] getInfiniteStringCases() {
        return new Object[]{
                new Object[]{"aba", 10, 7},
                new Object[]{"a", 1000000000,  1000000000}
        };
    }

    @Test
    @Parameters(method = " getInfiniteStringCases")
    public void parametricTestWithHackerRankCases(String s, long n, long result) {
        assertEquals(result, InfiniteString.repeatedString(s, n));
    }

    @Test
    public void useCaseFromSite(){
        InputStream inputTest = getClass().getResourceAsStream(USECASE_FILENAME);

        Scanner scan = new Scanner(inputTest);
        String s = scan.nextLine();

        long n = scan.nextLong();
        long expected = scan.nextLong();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = InfiniteString.repeatedString(s, n);

        assertEquals(expected, result);
        scan.close();
    }
}


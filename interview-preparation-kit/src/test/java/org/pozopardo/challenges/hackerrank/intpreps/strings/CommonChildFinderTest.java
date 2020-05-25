package org.pozopardo.challenges.hackerrank.intpreps.strings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.util.Scanner;

public class CommonChildFinderTest {

    @Test
    public void should_equalStrings_returnStringLength () {
        String s = "ABC";
        int result = CommonChildFinder.commonChild(s, s);

        assertEquals(s.length(), result);
    }

    @Test
    public void should_stringOneCharEqual_thenReturnOne() {
        String s1 = "AB";
        String s2 = "BC";
        int result = CommonChildFinder.commonChild(s1, s2);

        assertEquals(1, result);
    }

    @Test
    public void should_harryAndSallyComparison_thenReturnTwo() {
        String s1 = "HARRY";
        String s2 = "SALLY";

        assertEquals(2, CommonChildFinder.commonChild(s1, s2));
    }

    @Test
    public void should_differentSringsBeCompared_thenReturn0() {
        String s1 = "AA";
        String s2 = "BB";

        assertEquals(0, CommonChildFinder.commonChild(s1, s2));
    }

    @Test
    public void should_shinchanAndNoharaaaBeCompared_thenReturn3() {
        String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";

        assertEquals(3, CommonChildFinder.commonChild(s1, s2));
    }

    @Test
    public void should_ABCDEFandFBDAMN_thenReturn2() {
        String s1 = "ABCDEF" ;
        String s2 = "FBDAMN";

        assertEquals(2, CommonChildFinder.commonChild(s2, s1));
    }

    @Test
    public void testCase1FromSite() {
        String s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
        String s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";

        assertEquals(15, CommonChildFinder.commonChild(s1, s2));
    }

    private static String CASE9_FILE = "/common-child-case9.txt";

    @Test
    public void testCase9FromSite() {
        InputStream inputStream = getClass().getResourceAsStream(CASE9_FILE);
        Scanner input = new Scanner(inputStream);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        int expectedResult = 1618;

        assertEquals(expectedResult, CommonChildFinder.commonChild(s1, s2));

        input.close();
    }
}

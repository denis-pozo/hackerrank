package org.pozopardo.hackerrank.number;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pozopardo.hackerrank.regex.TagContentExtractor;

import java.math.BigDecimal;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class BigDecimalSorterTest {

//    private static final Object[] getTestStrings() {
//        return $(
//                $("<h1>Nayeem loves counseling</h1>", "Nayeem loves counseling\n"),
//                $("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
//                        "Sanjay has no watch\nSo wait for a while\n"),
//                $("<Amee>safat codes like a ninja</amee>", "None\n"),
//                $("<h1>some</h1>", "some\n"),
//                $("<h1>had<h1>public</h1></h1>", "public\n"),
//                $("<h1>had<h1>public</h1515></h1>", "None\n"),
//                $("<h1><h1></h1></h1>", "None\n"),
//                $("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", "None\n"),
//                $(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", "None\n"),
//                $("<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>", "None\n"),
//                $("<>hello</>", "None\n"),
//                $("<>hello</><h>dim</h>", "dim\n"),
//                $("<>hello</><h>dim</h>>>>>", "dim\n"),
//                $("<SA premium>Imtiaz has a secret crush</SA premium>",
//                        "Imtiaz has a secret crush\n")
//        );
//    }

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

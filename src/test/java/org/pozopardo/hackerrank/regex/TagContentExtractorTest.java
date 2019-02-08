package org.pozopardo.hackerrank.regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class TagContentExtractorTest {


    private static final Object[] getTestStrings() {
       return $(
               $("<h1>Nayeem loves counseling</h1>", "Nayeem loves counseling\n"),
               $("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
                       "Sanjay has no watch\nSo wait for a while\n"),
               $("<Amee>safat codes like a ninja</amee>", "None\n"),
               $("<h1>some</h1>", "some\n"),
               $("<h1>had<h1>public</h1></h1>", "public\n"),
               $("<h1>had<h1>public</h1515></h1>", "None\n"),
               $("<h1><h1></h1></h1>", "None\n"),
               $("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", "None\n"),
               $(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", "None\n"),
               $("<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>", "None\n"),
               $("<>hello</>", "None\n"),
               $("<>hello</><h>dim</h>", "dim\n"),
               $("<>hello</><h>dim</h>>>>>", "dim\n"),
               $("<SA premium>Imtiaz has a secret crush</SA premium>",
                       "Imtiaz has a secret crush\n")
       );
    }

    @Test
    @Parameters(method = "getTestStrings")
    public void testExtractorAgainstGivenInputOutput(String line, String output)
    {
        String result = TagContentExtractor.extractContent(line);
        Assert.assertEquals(output, result);
    }
}

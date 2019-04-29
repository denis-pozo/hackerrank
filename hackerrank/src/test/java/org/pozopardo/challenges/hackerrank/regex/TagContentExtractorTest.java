package org.pozopardo.challenges.hackerrank.regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TagContentExtractorTest {


    private static final Object[] getTestStrings() {
       return new Object[]{
               new Object[]{"<h1>Nayeem loves counseling</h1>", "Nayeem loves counseling\n"},
               new Object[]{"<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
                       "Sanjay has no watch\nSo wait for a while\n"},
               new Object[]{"<Amee>safat codes like a ninja</amee>", "None\n"},
               new Object[]{"<h1>some</h1>", "some\n"},
               new Object[]{"<h1>had<h1>public</h1></h1>", "public\n"},
               new Object[]{"<h1>had<h1>public</h1515></h1>", "None\n"},
               new Object[]{"<h1><h1></h1></h1>", "None\n"},
               new Object[]{"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", "None\n"},
               new Object[]{">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", "None\n"},
               new Object[]{"<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>", "None\n"},
               new Object[]{"<>hello</>", "None\n"},
               new Object[]{"<>hello</><h>dim</h>", "dim\n"},
               new Object[]{"<>hello</><h>dim</h>>>>>", "dim\n"},
               new Object[]{"<SA premium>Imtiaz has a secret crush</SA premium>",
                       "Imtiaz has a secret crush\n"}
       };
    }

    @Test
    @Parameters(method = "getTestStrings")
    public void testExtractorAgainstGivenInputOutput(String line, String output)
    {
        String result = TagContentExtractor.extractContent(line);
        Assert.assertEquals(output, result);
    }
}

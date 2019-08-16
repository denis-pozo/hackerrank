package org.pozopardo.challenges.hackerrank.intpreps.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test
    public void testSubstrCount() {
        assertEquals(4, Palindrome.substrCount(4,"test"));
        assertEquals(5, Palindrome.substrCount(4,"ejaa"));

    }
}

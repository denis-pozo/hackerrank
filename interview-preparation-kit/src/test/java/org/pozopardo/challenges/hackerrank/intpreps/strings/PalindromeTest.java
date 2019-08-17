package org.pozopardo.challenges.hackerrank.intpreps.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test
    public void testSubstrCount() {
        assertEquals(4, Palindrome.substrCount(4,"test"));
        assertEquals(5, Palindrome.substrCount(4,"ejaa"));
        assertEquals(5, Palindrome.substrCount(4,"ejaa"));
        assertEquals(4, Palindrome.substrCount(3,"eje"));
        assertEquals(12, Palindrome.substrCount(8,"mnonopoo"));
        assertEquals(7, Palindrome.substrCount(5,"asasd"));
        assertEquals(10, Palindrome.substrCount(7,"abcbaba"));

    }
}

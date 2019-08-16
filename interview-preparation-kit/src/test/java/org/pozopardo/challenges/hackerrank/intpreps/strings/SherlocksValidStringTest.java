package org.pozopardo.challenges.hackerrank.intpreps.strings;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SherlocksValidStringTest {

    @Test
    public void testIsValid() {
        assertEquals("YES", SherlocksValidString.isValid("abc"));
        assertEquals("YES", SherlocksValidString.isValid("aabc"));
        assertEquals("YES", SherlocksValidString.isValid("abbc"));
        assertEquals("YES", SherlocksValidString.isValid("abcc"));
        assertEquals("YES", SherlocksValidString.isValid("abbcc"));
        assertEquals("YES", SherlocksValidString.isValid("aabbc"));
        assertEquals("YES", SherlocksValidString.isValid("aabcc"));
        assertEquals("YES", SherlocksValidString.isValid("aaabbbc"));
        assertEquals("YES", SherlocksValidString.isValid("abbbccc"));
        assertEquals("NO", SherlocksValidString.isValid("aabbcd"));
        assertEquals("NO", SherlocksValidString.isValid("aabbccddeefghi"));
        assertEquals("NO", SherlocksValidString.isValid("aaaabbcc"));
        assertEquals("NO", SherlocksValidString.isValid("xxxaabbccrry"));
    }

}

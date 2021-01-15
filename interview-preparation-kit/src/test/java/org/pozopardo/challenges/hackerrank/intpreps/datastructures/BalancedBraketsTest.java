package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BalancedBraketsTest {

    @Test
    public void testCase18_00() {
        String input = "{[()]}";
        assertEquals("YES", BalancedBrakets.isBalanced(input));
    }

    @Test
    public void testCase18_01() {
        String input = "{[(])}";
        assertEquals("NO", BalancedBrakets.isBalanced(input));
    }

    @Test
    public void testCase18_02() {
        String input = "{{[[(())]]}}";
        assertEquals("YES", BalancedBrakets.isBalanced(input));
    }

    @Test
    public void testCase2_01() {
        String input = "{(([])[])[]}";
        assertEquals("YES", BalancedBrakets.isBalanced(input));
    }

    @Test
    public void testCase2_02() {
        String input = "{(([])[])[]]}";
        assertEquals("NO", BalancedBrakets.isBalanced(input));
    }
}

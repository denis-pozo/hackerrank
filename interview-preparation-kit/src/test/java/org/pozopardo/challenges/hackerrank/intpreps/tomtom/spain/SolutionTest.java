package org.pozopardo.challenges.hackerrank.intpreps.tomtom.spain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void exampleOneTest() {
        int[] testSample = new int [] {4, 7, 1, 5, 3};
        // Implement your solution here
        assertEquals(4, Solution.solution(testSample));
    }

    @Test
    public void exampleTwoTest() {
        int[] testSample = new int [] {12, 12, 12, 15, 10};
        // Implement your solution here
        assertEquals(3, Solution.solution(testSample));
    }

    @Test
    public void exampleThreeTest() {
        int[] testSample = new int [] {18, 26, 18, 24, 24, 20, 22};
        // Implement your solution here
        assertEquals(5, Solution.solution(testSample));
    }
}

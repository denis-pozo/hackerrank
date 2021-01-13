package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryTreeHeightCalculatorTest {

    @Test
    public void testCase00() {
       int [] data = new int [] {3, 5, 2, 1, 4, 6, 7};
       Node tree = BinaryTreeHeightCalculator.createBinaryTree(data);
       assertEquals(3, BinaryTreeHeightCalculator.height(tree));
    }

    @Test
    public void testCase04() {
        int [] data = new int [] {15};
        Node tree = BinaryTreeHeightCalculator.createBinaryTree(data);
        assertEquals(0, BinaryTreeHeightCalculator.height(tree));
    }

    @Test
    public void testCase05() {
        int [] data = new int [] {3, 1, 7, 5, 4};
        Node tree = BinaryTreeHeightCalculator.createBinaryTree(data);
        assertEquals(3, BinaryTreeHeightCalculator.height(tree));
    }

}

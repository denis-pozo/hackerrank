package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryTreeTraverserTest {


    @Test
    public void testCase00() {
        int [] data = new int [] {1, 2, 5, 3, 6, 4};
        Node tree = BinaryTreeTraverser.createBinaryTree(data);
        String output = "1 2 5 3 6 4";
        assertEquals(output, BinaryTreeTraverser.getLevelData(tree));
    }
}


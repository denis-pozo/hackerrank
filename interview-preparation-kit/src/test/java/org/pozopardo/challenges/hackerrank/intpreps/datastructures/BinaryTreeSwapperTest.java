package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BinaryTreeSwapperTest {

    @Test
    public void testCase00() {
        int[][] indexes = new int[3][2];
        indexes[0] = new int []{2, 3};
        indexes[1] = new int []{-1, -1};
        indexes[2] = new int []{-1, -1};
        BinaryTree tree = new BinaryTree(indexes);
        Node root = tree.getRoot();

        assertEquals(1, root.data);
        assertEquals(2, root.left.data);
        assertEquals(3, root.right.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);

        BinaryTreeSwapper.swap(root, 1, 1);
        assertEquals(1, root.data);
        assertEquals(3, root.left.data);
        assertEquals(2, root.right.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
        int [] result = BinaryTreeSwapper.getInOrderTraversal(root);
        int [] expected = new int[]{3, 1, 2};
        for(int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }

        BinaryTreeSwapper.swap(root, 1, 1);
        assertEquals(1, root.data);
        assertEquals(2, root.left.data);
        assertEquals(3, root.right.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
        result = BinaryTreeSwapper.getInOrderTraversal(root);
        expected = new int[]{2, 1, 3};
        for(int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testCase01() {
        int[][] indexes = new int[5][2];
        indexes[0] = new int []{2, 3};
        indexes[1] = new int []{-1, 4};
        indexes[2] = new int []{-1, 5};
        indexes[3] = new int []{-1, -1};
        indexes[4] = new int []{-1, -1};
        BinaryTree tree = new BinaryTree(indexes);
        Node root = tree.getRoot();

        assertEquals(1, root.data);
        assertEquals(2, root.left.data);
        assertEquals(3, root.right.data);
        assertNull(root.left.left);
        assertEquals(4, root.left.right.data);
        assertNull(root.right.left);
        assertEquals(5, root.right.right.data);
        assertNull(root.left.right.left);
        assertNull(root.left.right.right);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);

        BinaryTreeSwapper.swap(root, 2, 1);
        assertEquals(1, root.data);
        assertEquals(2, root.left.data);
        assertEquals(3, root.right.data);
        assertEquals(4, root.left.left.data);
        assertNull(root.left.right);
        assertEquals(5, root.right.left.data);
        assertNull(root.right.right);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);
        int [] result = BinaryTreeSwapper.getInOrderTraversal(root);
        int [] expected = new int[]{4, 2, 1, 5, 3};
        for(int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testCase03() {
        int[][] indexes = new int[11][2];
        indexes[0] = new int []{2, 3};
        indexes[1] = new int []{4, -1};
        indexes[2] = new int []{5, -1};
        indexes[3] = new int []{6, -1};
        indexes[4] = new int []{7, 8};
        indexes[5] = new int []{-1, 9};
        indexes[6] = new int []{-1, -1};
        indexes[7] = new int []{10, 11};
        indexes[8] = new int []{-1, -1};
        indexes[9] = new int []{-1, -1};
        indexes[10] = new int []{-1, -1};
        BinaryTree tree = new BinaryTree(indexes);
        Node root = tree.getRoot();

        assertEquals(1, root.data);
        assertEquals(2, root.left.data);
        assertEquals(3, root.right.data);
        assertEquals(4, root.left.left.data);
        assertNull(root.left.right);
        assertEquals(5, root.right.left.data);
        assertNull(root.right.right);
        assertEquals(6, root.left.left.left.data);
        assertNull(root.left.left.right);
        assertEquals(7, root.right.left.left.data);
        assertEquals(8, root.right.left.right.data);
        assertNull(root.left.left.left.left);
        assertEquals(9, root.left.left.left.right.data);
        assertNull(root.right.left.left.left);
        assertNull(root.right.left.left.right);
        assertEquals(10, root.right.left.right.left.data);
        assertNull(root.right.left.right.left.left);
        assertNull(root.right.left.right.left.right);
        assertEquals(11, root.right.left.right.right.data);
        assertNull(root.right.left.right.right.left);
        assertNull(root.right.left.right.right.right);

        BinaryTreeSwapper.swap(root, 2, 1);
        assertEquals(1, root.data);
        assertEquals(2, root.left.data);
        assertNull(root.left.left);
        assertEquals(4, root.left.right.data);
        assertEquals(6, root.left.right.left.data);
        assertNull(root.left.right.right);
        assertEquals(9, root.left.right.left.left.data);
        assertNull(root.left.right.left.right);
        assertEquals(3, root.right.data);
        assertNull(root.right.left);
        assertEquals(5, root.right.right.data);
        assertEquals(7, root.right.right.left.data);
        assertNull(root.right.right.left.left);
        assertNull(root.right.right.left.right);
        assertEquals(8, root.right.right.right.data);
        assertEquals(11, root.right.right.right.left.data);
        assertNull(root.right.right.right.left.left);
        assertNull(root.right.right.right.left.right);
        assertEquals(10, root.right.right.right.right.data);
        assertNull(root.right.right.right.right.left);
        assertNull(root.right.right.right.right.right);
        int [] result = BinaryTreeSwapper.getInOrderTraversal(root);
        int [] expected = new int[]{2, 9, 6, 4, 1, 3, 7, 5, 11, 8, 10};
        for(int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }

        BinaryTreeSwapper.swap(root, 4, 1);
        result = BinaryTreeSwapper.getInOrderTraversal(root);
        expected = new int[]{2, 6, 9, 4, 1, 3, 7, 5, 10, 8, 11};
        for(int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }
}

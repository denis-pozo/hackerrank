package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import java.util.*;
import java.io.*;

public class BinaryTreeHeightCalculator {

    public static Node createBinaryTree(int [] data) {
        int n = data.length;
        int i = 0;
        Node root = null;
        while(n-- > 0) {
            root = insert(root, data[i++]);
        }
        return root;
    }

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        if(root.left == null && root.right == null) {
            return 0;
        }

        int heightLeft = 0;
        if(root.left != null) {
            heightLeft = height(root.left);
        }

        int rightHeight = 0;
        if(root.right != null) {
            rightHeight = height(root.right);

        }

        return Math.max(heightLeft, rightHeight) + 1;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}

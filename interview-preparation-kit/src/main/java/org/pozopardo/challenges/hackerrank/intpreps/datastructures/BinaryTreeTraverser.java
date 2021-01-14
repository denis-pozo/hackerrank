package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import java.util.*;
    import java.io.*;

public class BinaryTreeTraverser {
    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        System.out.println(getLevelData(root));
    }

    public static String getLevelData(Node node) {
        Map<Integer, List<Integer>> dataByLevel = new HashMap<>();
        int level = 0;
        dataByLevel.put(level, Arrays.asList(node.data));

        fillTheMap(dataByLevel, level+1, node);
        return getTheLevelData(dataByLevel);
    }

    private static void fillTheMap(
        Map<Integer, List<Integer>> dataByLevel, int level, Node node) {
        List<Integer> data;
        if(dataByLevel.containsKey(level)) {
            data = dataByLevel.get(level);
        } else {
            data = new ArrayList<>();
        }

        if(node.left != null) {
            data.add(node.left.data);
        }
        if(node.right != null) {
            data.add(node.right.data);
        }

        dataByLevel.put(level, data);

        if(node.left != null) {
            fillTheMap(dataByLevel, level+1, node.left);
        }

        if(node.right != null) {
            fillTheMap(dataByLevel, level+1, node.right);
        }
    }

    private static String getTheLevelData(Map<Integer, List<Integer>> dataByLevel) {
        int i = 0;
        StringBuffer buffer = new StringBuffer();
        while(dataByLevel.containsKey(i)) {
            dataByLevel.get(i).stream().forEach(x -> buffer.append(x + " "));
            i++;
        }
        return buffer.subSequence(0, buffer.length()-1).toString();
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
        levelOrder(root);
    }

    public static Node createBinaryTree(int [] data) {
        int n = data.length;
        int i = 0;
        Node root = null;
        while(n-- > 0) {
            root = insert(root, data[i++]);
        }
        return root;
    }
}

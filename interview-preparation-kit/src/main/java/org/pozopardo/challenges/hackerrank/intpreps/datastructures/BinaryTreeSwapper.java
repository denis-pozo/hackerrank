package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class BinaryTree {
    private final Node root = new Node(1);

    public BinaryTree(int[][] tree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int valueLeft = tree[node.data-1][0];
            if(valueLeft != -1) {
                node.left = new Node(valueLeft);
                queue.add(node.left);
            }

            int valueRight = tree[node.data-1][1];
            if(valueRight != -1){
                node.right = new Node(valueRight);
                queue.add(node.right);
            }
        }
    }

    public Node getRoot(){
        return root;
    }
}

public class BinaryTreeSwapper {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        BinaryTree tree = new BinaryTree(indexes);
        int [][] result = new int[queries.length][];
        for(int i = 0; i < queries.length; i++) {
            swap(tree.getRoot(), queries[i], 1);
            result[i]  = getInOrderTraversal(tree.getRoot());
        }
        return result;
    }

    public static int[] getInOrderTraversal(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        traverseInOrder(root, inOrder);
        // int [] result = new int[inOrder.size()];
        // for(int i = 0; i < result.length; i++) {
        //     result[i] = inOrder.get(i);
        // }
        return inOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void traverseInOrder(Node root, List<Integer> inOrder) {
        if(root == null) {
            return;
        }

        traverseInOrder(root.left, inOrder);
        inOrder.add(root.data);
        traverseInOrder(root.right, inOrder);
    }

    public static void swap(Node root, int query, int level) {
        if(level % query == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        if(root.left != null) {
            swap(root.left, query, level+1);
        }

        if(root.right != null) {
            swap(root.right, query, level+1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

// class Node {
//     private Node right;
//     private Node left;
//     private final int index;
//
//     public Node(int index) {
//         this.index = index;
//     }
//
//     public void setRight(int right) {
//         this.right = new Node(right);
//     }
//
//     public void setLeft(int left) {
//         this.left = new Node(left);
//     }
//
// }

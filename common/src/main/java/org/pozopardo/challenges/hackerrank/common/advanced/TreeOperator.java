package org.pozopardo.challenges.hackerrank.common.advanced;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);

    @Override
    public String toString() {
        return "Value:" + getValue() +
                " Color:" + getColor() +
                " Depth:" + getDepth();
    }
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        // does nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum = sum + leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if(node.getColor() == Color.RED){
            product = (product * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.RED){
            product = (product * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 == 0) {
            evenSum = evenSum + node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.GREEN) {
            greenLeafSum = greenLeafSum + leaf.getValue();
        }
    }
}

class PrintVisitor extends TreeVis {
    private int nodes = 0;

    public int getResult() {
        return nodes;
    }

    public void visitNode(TreeNode node) {
        nodes++;
        System.out.println(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        nodes++;
        System.out.println(leaf);
    }
}

public class TreeOperator {

    private static int [] values;
    private static Color [] colors;
    private static Map<Integer, HashSet<Integer>> edges;

    public static Tree solve(Scanner input) {
        int nNodes = input.nextInt();
        int nEdges = nNodes-1;

        readValues(nNodes, input);
        readColors(nNodes, input);
        readEdges(nEdges, input);

        if(nNodes == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        }

        TreeNode root = new TreeNode(values[0], colors[0], 0);
        createChildren(root, 1);
        return root;
    }

    private static void readValues(int nNodes, Scanner input) {
        values = new int[nNodes];
        for(int i = 0 ; i < nNodes ; i++) {
            values[i] = input.nextInt();
        }
    }

    private static void readColors(int nNodes, Scanner input) {
        colors = new Color[nNodes];
        for(int i = 0 ; i < nNodes ; i++) {
            int color = input.nextInt();
            if(color == 0){
                colors[i] = Color.RED;
            } else {
                colors[i] = Color.GREEN;
            }
        }
    }

    private static void readEdges(int nEdges, Scanner input) {
        edges = new HashMap<>();
        for(int i = 0 ; i < nEdges ; i++) {
            int xEnd = input.nextInt();
            int yEnd = input.nextInt();

            HashSet<Integer> xNeighbors = edges.get(xEnd);
            if(xNeighbors == null){
                xNeighbors = new HashSet<>();
                edges.put(xEnd, xNeighbors);
            }
            xNeighbors.add(yEnd);

            HashSet<Integer> yNeighbors = edges.get(yEnd);
            if(yNeighbors == null) {
                yNeighbors = new HashSet<>();
                edges.put(yEnd, yNeighbors);
            }
            yNeighbors.add(xEnd);
        }
    }

    private static void createChildren(TreeNode parentNode, int parentID) {
        Set<Integer> childrenIDs = edges.get(parentID);
        for(int childID : childrenIDs) {
            edges.get(childID).remove(parentID);

            if (isLeaf(childID)) {
                parentNode.addChild(new TreeLeaf(values[childID - 1], colors[childID - 1], parentNode.getDepth() + 1));
            } else {
                TreeNode childNode = new TreeNode(values[childID - 1], colors[childID - 1], parentNode.getDepth() + 1);
                createChildren(childNode, childID);
                parentNode.addChild(childNode);
            }
        }
    }

    private static boolean isLeaf(int childID) {
        HashSet<Integer> grandChildren = edges.get(childID);
        if(grandChildren != null && !grandChildren.isEmpty()) return false;
        else return true;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tree root = solve(input);
        input.close();

        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();
        PrintVisitor vis4 = new PrintVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);
        root.accept(vis4);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();
        int res4 = vis4.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}

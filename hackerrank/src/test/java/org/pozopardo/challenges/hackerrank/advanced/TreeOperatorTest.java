package org.pozopardo.challenges.hackerrank.advanced;

import java.io.InputStream;
import java.util.Scanner;


public class TreeOperatorTest {

    public static void main(String [] args) {
        InputStream fileTest = TreeOperatorTest.class.getResourceAsStream("/tree-visitor-input.txt");
        Scanner scan = new Scanner(fileTest);
        Tree root = TreeOperator.solve(scan);
        scan.close();

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

package org.pozopardo.hackerrank.data.structure;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class BitSetOperator {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<BitSet> b = new ArrayList<>(2);
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        b.add(b1);
        b.add(b2);

        for(int i = 0 ; i < m ; i++) {
            String operation = in.next("AND|SET|FLIP|OR");
            int left = in.nextInt();
            int right = in.nextInt();
            processOperation(operation, b, left, right);
            System.out.println(b.get(0).cardinality() + " " + b.get(1).cardinality());
        }

    }

    static void processOperation(String operation, List<BitSet> b, int left, int right) {
        if(operation.equals("AND")) {
            b.get(left-1).and(b.get(right-1));
        }
        if(operation.equals("SET")) {
            b.get(left-1).set(right);
        }
        if(operation.equals("FLIP")) {
            b.get(left-1).flip(right);
        }
        if(operation.equals("OR")) {
            b.get(left-1).or(b.get(right-1));
        }
        if(operation.equals("XOR")) {
            b.get(left-1).xor(b.get(right-1));
        }
    }
}

package org.pozopardo.challenges.hackerrank.intpreps.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    // The complexity of this algorithm is O(2^n) due to the recursive algorithm
    static void minimumBribes(int[] q) {
        int count = 0;

        for (int i = q.length -1 ; i >= 0 ; i--) {
            int bribes = permute(q, i);
            if( bribes >= 3) {
                System.out.println("Too chaotic");
                return;
            }
            count += bribes;
        }

//        for (Integer newOrder : q) {
//            int bribes = newOrder - originalOrder;
//            if(bribes > 0 && bribes < 3) {
//                count = count + bribes;
//            } else if (bribes >= 3){
//                System.out.println("Too chaotic");
//                return;
//            }
//
//            originalOrder++;
//        }
        System.out.println(count);

    }

    static int permute(int [] q, int index) {
        if(index < 0 || index == q.length-1)
            return 0;

        if(q[index] > q[index+1]) {
            int current = q[index];
            int next = q[index+1];
            q[index + 1] = current;
            q[index] = next;
            return 1 + permute(q, ++index);
        } else {
            return 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

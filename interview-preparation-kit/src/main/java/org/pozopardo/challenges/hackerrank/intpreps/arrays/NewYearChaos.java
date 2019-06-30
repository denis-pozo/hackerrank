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
    static void minimumBribes(int[] q) {
        int count = 0;

        for(int i = q.length ; i > 0 ; i--) {
            int bribes = countBribes(q, i);
            if (bribes < 0 || bribes > 2) {
                System.out.println("Too chaotic");
                return;
            } else {
                count += bribes;
            }
        }
        System.out.println(count);

    }

    private static int countBribes(int[] line, int order) {
        if(line[order-1] == order) return 0;
        else {
            for(int i = 0 ; i < line.length ; i++) {
                if(line[i] == order) {
                    return line.length-1 - i;
                }
            }
        }
        return -1;
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

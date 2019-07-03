package org.pozopardo.challenges.hackerrank.intpreps.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulator {

    /* This solution is O(n)
     * In this solution, only the changes are stored. Only the new values are added to the starting position and
     * are subtracted after the last position. So, max 2 operations are carried out in every iteration. To recreate the
     * full array after every modification we just need to add to value at i the previous value i-1
     */

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long [] diff = new long[n];

        for (int i = 0; i < queries.length; i++) {
            long value = queries[i][2];
            int startAt = queries[i][0];
            int endAt = queries[i][1];

            diff[startAt-1] = diff[startAt-1] + value;
            if(endAt < n) diff[endAt] = diff[endAt] - value;
        }

        long max = Long.MIN_VALUE;
        long temp = 0;
        for(int i = 0 ; i < n ; i++) {
            temp += diff[i];
            if(temp > max) max = temp;
        }
        return max;
    }


//    // This solution is O(n^2)
//    // Complete the arrayManipulation function below.
//    static long arrayManipulation(int n, int[][] queries) {
//        long [] array = new long [n];
//        long max = Long.MIN_VALUE;
//
//        for(int i = 0 ; i < queries.length ; i++) {
//            long res = addValue(array, queries[i][0], queries[i][1], queries[i][2]);
//            if(res > max) max = res;
//        }
//        return max;
//    }
//
//    private static long addValue(long[] array, int beginIndex, int endIndex, int value) {
//        long max = Long.MIN_VALUE;
//
//        for(int i = beginIndex-1 ; i <= endIndex-1 ; i++) {
//            long result = array[i] + value;
//            if(result > max) max = result;
//            array[i] = result;
//        }
//        return max;
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

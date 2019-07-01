package org.pozopardo.challenges.hackerrank.intpreps.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArraySorter {

    // Complete the minimumSwaps function below.
    // This algorithm's order is O(n)
    static int minimumSwaps(int[] arr) {
        Map<Integer, Integer> indexes = new HashMap<>(arr.length);

        for(int i = 0 ; i < arr.length ; i++) {
            indexes.put(arr[i], i);
        }

        int count = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] != i+1 ) {
                int currentValue = arr[i];
                int correctValue = i+1;
                int nextIndex = indexes.get(correctValue);
                arr[i] = correctValue;
                arr[nextIndex] = currentValue;
                indexes.put(correctValue, i);
                indexes.put(currentValue, nextIndex);
                count ++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        scanner.close();
    }
}

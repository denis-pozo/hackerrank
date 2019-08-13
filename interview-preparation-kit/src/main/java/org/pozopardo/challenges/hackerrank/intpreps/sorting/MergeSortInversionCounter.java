package org.pozopardo.challenges.hackerrank.intpreps.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MergeSortInversionCounter {

    // Complete the countInversions function below.
    // This algorithm has a time complexity O(2^n)
    static long countInversions(int[] arr) {
        int [] temp = new int [arr.length];
        int leftStart = 0;
        int rightEnd = arr.length-1;
        return mergeSortCount(arr, temp, leftStart, rightEnd);
    }

    private static long mergeSortCount(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long count = 0;
        if ( leftStart >= rightEnd ) return 0;

        int middle =  (leftStart + rightEnd) / 2;

        count += mergeSortCount(arr, temp, leftStart, middle);
        count += mergeSortCount(arr, temp, middle + 1, rightEnd);
        count += mergeHalvesCount(arr, temp, leftStart, rightEnd);
        return count;
    }

    private static long mergeHalvesCount(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long count = 0;
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftStart;

        while ( leftIndex <= leftEnd && rightIndex <= rightEnd ) {
            if(arr[leftIndex] <= arr[rightIndex]) {
                temp[index] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[index] = arr[rightIndex];
                count += rightIndex - index;
                rightIndex++;
            }
            index++;
        }

        System.arraycopy(arr, leftIndex, temp, index, leftEnd - leftIndex + 1);
        System.arraycopy(arr, rightIndex, temp, index, rightEnd - rightIndex + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String [] arrItems = null;
            do {
                arrItems = scanner.nextLine().split(" ");
            } while (arrItems == null || arrItems.length == 0);
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


package org.pozopardo.challenges.hackerrank.intpreps.arrays;

import java.io.*;
import java.util.*;

public class HourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourglass = Integer.MIN_VALUE;

        for(int i = 1 ; i < arr.length-1 ; i++) {
            for(int j = 1 ; j < arr[i].length-1 ; j++) {
                int hourglass = computeHourglass(arr, i, j);
                if(hourglass > maxHourglass) { maxHourglass = hourglass; }
            }
        }

        return maxHourglass;
    }

    private static int computeHourglass(int[][] arr, int i, int j) {
        int count = 0;

        for(int m = i-1 ; m <= i+1 ; m++){
            for(int n = j-1 ; n <= j+1 ; n++) {
                if(!(m == i && n != j)) count += arr[m][n];
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

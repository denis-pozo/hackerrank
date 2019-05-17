package org.pozopardo.challenges.hackerrank.intpreps.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayOperator {

    public static int [] rotateLeft(int[] originalArray, int rotations) {
        int len = originalArray.length;
        int [] rotatedArr = new int[len];

        for(int i = 0 ; i < len ; i++) {
            if( i < rotations ) {
                rotatedArr[len-rotations+i] = originalArray[i];
            } else {
                rotatedArr[i-rotations] = originalArray[i];
            }
        }

        return rotatedArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotateLeft(a, d);

        for (int i = 0; i < result.length-1; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println(result[result.length-1]);

        scanner.close();
    }
}

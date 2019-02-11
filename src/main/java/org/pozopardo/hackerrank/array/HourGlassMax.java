package org.pozopardo.hackerrank.array;

import java.util.Scanner;

public class HourGlassMax {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        System.out.println(largestSum(arr));

        scanner.close();
    }

    public static int largestSum(int[][] arr) {
        int largest = Integer.MIN_VALUE;

        for(int i = 1 ; i < arr.length-1 ; i++) {
            for(int j = 1 ; j < arr[i].length-1 ; j++) {
               int sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1];
               sum = sum + arr[i][j];
               sum = sum + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
               if(sum > largest) {
                   largest = sum;
               }
            }
        }

        return largest;
    }

}

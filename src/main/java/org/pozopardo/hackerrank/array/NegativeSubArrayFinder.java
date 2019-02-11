package org.pozopardo.hackerrank.array;

import java.util.*;

public class NegativeSubArrayFinder {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer [] array = new Integer[n];

        for(int i = 0 ; i < n ; i++) {
            array[i] = scanner.nextInt();
        }

        int count = countTotalNegativeSubarrays(array);
        System.out.println(count);
        scanner.close();
    }

    static int countTotalNegativeSubarrays(Integer [] array) {
        int count = 0;

        for(int sublength = 1 ; sublength <= array.length ; sublength++) {
            count = count + countNegativeSubarraysOfLength(array, sublength);
        }
        return count;
    }

    private static int countNegativeSubarraysOfLength(Integer [] array, int length) {
        int count = 0;
        List<Integer> arrayList = Arrays.asList(array);

        for(int i = 0 ; i <= array.length-length ; i++) {
            List<Integer> subArrays = arrayList.subList(i, i+length);
            int sum = subArrays.stream().mapToInt(Integer::intValue).sum();
            if(sum < 0) count++;
        }

        return count;
    }
}

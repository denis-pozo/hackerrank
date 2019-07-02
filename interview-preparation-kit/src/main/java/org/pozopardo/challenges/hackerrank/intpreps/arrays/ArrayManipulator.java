package org.pozopardo.challenges.hackerrank.intpreps.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulator {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        List<Integer> changes = new ArrayList<>();
        changes.add(0);

        for(int i = 0 ; i < queries.length ; i++) {
            long value = queries[i][2];
            int startAt = queries[i][0] - 1;
            int endAt = queries[i][1] - 1;

            int firstChangeIndex;
            if(startAt == 0) firstChangeIndex = 0;
            else {
                firstChangeIndex = findStartPosition(changes, startAt);
            }
            addChange(changes, firstChangeIndex, startAt);

            int endOfChangeIndex;
            if(endAt == n-1) {
                endOfChangeIndex = changes.size();
            } else {
                endOfChangeIndex = findEndPosition(changes, endAt);
            }
            addChange(changes, endOfChangeIndex, endAt);
            System.out.println(changes);
        }
        return 0;
    }


    private static void addChange(List<Integer> changes, int index, int changeAt) {
        
        if(index >= changes.size()) {
            changes.add(changeAt);
        } else if(changes.get(index) != changeAt) {
            changes.add(index, changeAt);
        }
    }

    private static int findStartPosition(List<Integer> changes, int startAt) {
        int count = 0;
        for(Integer index : changes) {
            if(index >= startAt) {
                return count;
            }
            count++;
        }
        return count;
    }

    private static int findEndPosition(List<Integer> changes, int endAt) {
        for(int i = changes.size()-1 ; i >= 0 ; i--) {
            if(changes.get(i) < endAt + 1) {
                return i + 1;
            }
        }
        return 0;
    }
    // Complete the arrayManipulation function below.
//    // Algorithm's time cost O(n^2)
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


//        List<Long> values = new ArrayList<>();
//        List<Integer> changes = new ArrayList<>();
//        Long max = Long.MIN_VALUE;
//
//        values.add(0L);
//        changes.add(0);
//
//        for(int i = 0 ; i < queries.length ; i++) {
//            printArrays(changes, values, n);
//            long value = queries[i][2];
//            int startAt = queries[i][0] - 1;
//            int endAt = queries[i][1] - 1;
//
//            int currentPosition = findStartPosition(changes, startAt);
//
//            long newValue = 0;
//            long oldValue = 0;
//            if(currentPosition >= changes.size()) {
//                oldValue = changes.get(changes.size()-1);
//                newValue = value + oldValue;
//                values.add(newValue);
//                values.add(oldValue);
//                changes.add(startAt);
//                changes.add(endAt+1);
//                break;
//            } else if(startAt == changes.get(currentPosition)) {
//                oldValue = values.remove(currentPosition);
//                newValue = value + oldValue;
//                values.add(currentPosition, newValue);
//            } else if(startAt < changes.get(currentPosition)){
//                oldValue = values.get(currentPosition-1);
//                newValue = value + oldValue;
//                values.add(currentPosition, newValue);
//                changes.add(currentPosition, startAt);
//            }
//            if(newValue > max) max = newValue;
//
//            currentPosition++;
//            boolean updated = false;
//            if(currentPosition >= changes.size()) {
//                changes.add(endAt+1);
//                values.add(oldValue);
//                updated = true;
//            }
//
//            while (!updated && currentPosition < changes.size()-1) {
//                if(changes.get(currentPosition)-1 < endAt) {
//                    oldValue = values.remove(currentPosition);
//                    newValue = value + oldValue;
//                    values.add(currentPosition, newValue);
//                } else if (changes.get(currentPosition)-1 >= endAt) {
//                    updated = true;
//                }
//                if(newValue > max) max = newValue;
//                currentPosition++;
//            }
//        }
//        return max;
//    }

//    private static int getNextPosition(List<Integer> changes, int currentPosition, int endAt) {
//        for(int i = currentPosition ; i < changes.size() ; i++) {
//            if(changes.get(i)
//        }
//
//    }


    private static void printArrays(List<Integer> changes, List<Long> values, int n) {
        long [] array = new long[n];

        if(changes.size() > 1) {
            for(int i = 0 ; i < changes.size()-1 ; i++) {
                fulfillArray(array, changes.get(i), changes.get(i+1), values.get(i));
            }
            fulfillArray(array, changes.get(changes.size()-1), n-1, values.get(values.size()-1));
        }

        System.out.println("Indexes: " + changes);
        System.out.println("Values: " + values);
        System.out.println("Resulting array: " + Arrays.toString(array));
    }

    private static void fulfillArray(long[] array, int startAt, int endAt, long value) {
        for(int i = startAt ; i < endAt ; i++) {
            array[i] = value;
        }
    }

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

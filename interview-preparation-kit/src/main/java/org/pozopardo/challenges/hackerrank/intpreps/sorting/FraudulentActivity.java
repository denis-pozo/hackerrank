package org.pozopardo.challenges.hackerrank.intpreps.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentActivity {

    private final static int SORT_RANGE = 201;

    // Complete the activityNotifications function below.
    // The complexity of this algorithm is O(SORT_RANGE)
    static int activityNotifications(int[] expenditure, int d) {
        Queue<Integer> subExpenditure = new LinkedList<>();
        int [] occurrences = new int[SORT_RANGE];

        for(int i = 0 ; i < d ; i++) {
            subExpenditure.add(expenditure[i]);
            occurrences[expenditure[i]]++;
        }

        int count = 0;
        for(int i = d ; i < expenditure.length ; i++) {
            double median = calculateMedian(occurrences, d);
            if(expenditure[i] >= 2 * median) count++;
            int out = subExpenditure.remove();
            occurrences[out]--;
            subExpenditure.add(expenditure[i]);
            occurrences[expenditure[i]]++;
        }

        return count;
    }

    private static double calculateMedian(int [] occurrences, int d) {
        int [] occurSum = new int[SORT_RANGE];
        occurSum[0] = occurrences[0];

        for(int i = 1 ; i < occurrences.length ; i++){
            occurSum[i] = occurSum[i-1] + occurrences[i];
        }

        double a = 0;
        double b = 0;
        if(d % 2 == 0) {
            int first = d/2;
            int second = first+1;
            for(int i = 0 ; i < SORT_RANGE ; i++) {
                if(first <= occurSum[i]) {
                    a = i;
                    break;
                }
            }
            for(int i = 0 ; i < SORT_RANGE ; i++) {
                if(second <= occurSum[i]) {
                    b = i;
                    break;
                }
            }
            return (a+b)/2;
        } else {
            int first = d/2 + 1;
            for(int i = 0 ; i < SORT_RANGE ; i++) {
                if(first <= occurSum[i]) {
                    a = i;
                    break;
                }
            }
            return a;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

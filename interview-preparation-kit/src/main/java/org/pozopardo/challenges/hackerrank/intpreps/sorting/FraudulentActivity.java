package org.pozopardo.challenges.hackerrank.intpreps.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentActivity {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
//        int [] subExpenditure = new int [d];
        Queue<Integer> subExpenditure = new LinkedList<>();

        for(int i = 0 ; i < d ; i++) {
            subExpenditure.add(expenditure[i]);
        }

        int count = 0;
        for(int i = d ; i < expenditure.length-1 ; i++) {
            long median = calculateMedian(subExpenditure);
            if(expenditure[i] >= median) count++;
            subExpenditure.remove();
            subExpenditure.add(expenditure[i++]);
        }

        return count;
    }

    private static long calculateMedian(final Queue<Integer> expenditure) {
        List<Integer> copy = new LinkedList<>(expenditure);
        Collections.sort(copy);

        if(copy.size() % 2 == 0) {
            int half = copy.size() / 2;
            int a = copy.get(half-1);
            int b = copy.get(half);
            return (a+b)/2;
        } else {
            int half = Math.round(copy.size() / 2);
            return copy.get(half);
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
